test {
    [...]
    doFirst {
        def testFilter = System.getProperty('testFilter')
        if (testFilter) {
            def testFilterParts = testFilter.split(',')
            testFilterParts.each {
                item ->
                    filter {
                        includeTestsMatching item
                    }
            }
        }
    }
    [...]
}