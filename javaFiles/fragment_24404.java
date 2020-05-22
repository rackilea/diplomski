afterEvaluate {
    project.android.applicationVariants.all { com.android.build.gradle.api.ApplicationVariant variant ->
        Task obfuscateTask = variant.obfuscation
        def skipReason = [ ];
        if (obfuscateTask == null) { skipReason += "not obfuscated" }
        if (!variant.buildType.debuggable) { skipReason += "not debuggable" }
        if (variant.testVariant != null) { skipReason += "tested" }
        if (!skipReason.isEmpty()) {
            logger.info("Skipping unfuscation of {} because it is {}", variant.name, skipReason);
            return;
        }

        File mapping = variant.mappingFile
        File newMapping = new File(mapping.parentFile, "unmapping.txt")

        Task unfuscateTask = project.task("${obfuscateTask.name}Unfuscate") {
            inputs.file mapping
            outputs.file newMapping
            outputs.upToDateWhen { mapping.lastModified() <= newMapping.lastModified() }
            doLast {
                java.lang.reflect.Field configField =
                        proguard.gradle.ProGuardTask.class.getDeclaredField("configuration")
                configField.accessible = true
                proguard.Configuration config = configField.get(obfuscateTask) as proguard.Configuration
                if (!config.obfuscate) return; // nothing to unfuscate when -dontobfuscate

                java.nio.file.Files.copy(mapping.toPath(), new File(mapping.parentFile, "mapping.txt.bck").toPath(),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING)
                logger.info("Writing new mapping file: {}", newMapping)
                new Mapping(mapping).remap(newMapping)

                logger.info("Re-executing {} with new mapping...", obfuscateTask.name)
                config.applyMapping = newMapping // use our re-written mapping file
                //config.note = [ '**' ] // -dontnote **, it was noted in the first run

                LoggingManager loggingManager = getLogging();
                // lower level of logging to prevent duplicate output
                loggingManager.captureStandardOutput(LogLevel.WARN);
                loggingManager.captureStandardError(LogLevel.WARN);
                new proguard.ProGuard(config).execute();
            }
        }
        unfuscateTask.dependsOn obfuscateTask
        variant.dex.dependsOn unfuscateTask
    }
}