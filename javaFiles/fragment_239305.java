distributions {
    main {
        baseName = "${project.name}"
        contents {
            into('/conf'){
                from('src/main/resources')
            }
            into('/bin'){
                from('build/libs')
            }
        }
    }
}