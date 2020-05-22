ant.copy(todir:"destination/directory") {
        fileset(dir: "source/directory")
        {
            include(name: "filename.zip")
        }
    }