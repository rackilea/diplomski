apply plugin: 'java'
sourceSets {
    main {
        java { 
            resources { 
                srcDirs = [ "foo" ]
                include '**/**'
                exclude '**/*.txt'
            } 
        }       
    }
}

processResources {
    with copySpec {
        from 'foo/file_a.txt'
        filter { String line ->
            line
                .replace("foo", "fool" )
            }   
    }

    with copySpec {
        from 'foo/file_b.txt'
        rename { "file_c.txt" }
        filter { String line ->
            line
                .replace("ipsum", "zzz" )
            }   
    }
}