task copynonJavafile<< {
copy{
 from("src"){
  exclude '**/*.java' }
 into("build/classes/main")
}
}

sourceSets {
    main {
        java {
            srcDir 'src'
        }
    }
    test {
        java {
            srcDir  'test'

        }
    }
}

jar.dependsOn copynonJavafile