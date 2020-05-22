doFirst {
        println 'Generating master changelog...'
        def changelogFiles = []
        configurations.runtime.each {
            def zip = new ZipFile(it)
            def entries = zip.entries()
            entries.findAll { entry -> entry.name.contains("liquibase") }
                    .findAll { entry -> entry =~ /changelog.xml/ }
                    .each { entry ->
                changelogFiles.add(((ZipEntry) entry).name)
            }

        }

        def resDir = sourceSets.main.output.resourcesDir.path + '/liquibase'

        def changelogFile = new File("$resDir/changelog-master.xml")

        changelogFile.write("<databaseChangeLog xmlns=\"http://www.liquibase.org/xml/ns/dbchangelog\"\n" +
                "                   xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "                   xsi:schemaLocation=\"http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-2.0.xsd\">\n\n")

        changelogFiles.each {
            println("Including $it to changelog.")
            changelogFile << "    <include file=\"classpath:$it\"/> \n"
        }

        changelogFile << "\n</databaseChangeLog>"

    }