plugins {
    id 'base'
}

configurations {
    // XXX added the same attribute as in the testA project
    myConfiguration {
        attributes {
            attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,
                      project.objects.named(LibraryElements, 'my-zipped-lib'))
        }
    }
}

dependencies {
    myConfiguration 'org.test:testA:0.0.0.+@zip'
}

task doubleZipTask(type: Zip) {
    from configurations.myConfiguration
}