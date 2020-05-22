class PersonSpec extends Specification {

    def 'test getting persons names'() {
        given:
        def searchPeople = new SearchPeopleImpl()

        when:
        def result = searchPeople.getPeopleNames(names)

        then:
        result == expectedNames

        where:
        names << [
            ["AA", "BB"].collect { n ->
            Mock(Person) {
                getName() >> n
            }
        }
        ]
        expectedNames << [["AA", "BB"]]
    }
}