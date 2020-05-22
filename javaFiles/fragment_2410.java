distZip {
    eachFile { file ->
        if (file.path.contains('bin')) {
            file.exclude()
        }
    }
}