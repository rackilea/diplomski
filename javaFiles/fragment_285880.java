class FooSpecTest extends Specification {
    def "test foo"() {
        when:
        boolean result = Foo.getBar({x -> x.contains("blah")} as Predicate<String>)
        then:
        result == true
    }
}