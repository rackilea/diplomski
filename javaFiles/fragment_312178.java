void "my test"(){
        given:
            Person person
        when:
            person = UnitTestUtils.createTestPerson(givenA)
        then:
            person.name == expected.name
            person.age == expected.age
        where:
          id| givenA        | expected
          1 | [name: "Joe"] | [name: "Joe", age: 45]
          2 | [age: 5]      | [name: "Jim Bob", age: 5]
    }