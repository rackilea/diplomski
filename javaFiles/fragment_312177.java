Person createTestPerson(Map overrides = [:]){
        Person p = new Person(name: "Jim Bob", age: 45)
        overrides.each { String key, value ->
            if(p.hasProperty(key)){
                p.setProperty(key, value)
            } else {
                println "Error: Trying to add property that doesn't exist"
            }
        }
        return p
    }