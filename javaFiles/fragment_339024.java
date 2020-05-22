plugins {
    id 'base'
    // Uncomment the line below to break the zip artifact
    //id 'java'
}

group = 'org.test'
version = '0.0.0.1_test'

task zipTask(type: Zip) {
    from './settings.gradle' // just so the zip isn't empty
}

// XXX added an attribute to the configuration
configurations.default.attributes {
    attribute(LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,
              project.objects.named(LibraryElements, 'my-zipped-lib'))
}

artifacts.add('default', zipTask)