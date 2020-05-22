tasks.withType(Checkstyle).each { checkstyleTask ->
    checkstyleTask.doLast {
        reports.all { report ->
            def outputFile = report.destination
            if (outputFile.exists() && outputFile.text.contains("<error ")) {
                throw new GradleException("There were checkstyle warnings! For more info check $outputFile")
            }
        }
    }
}