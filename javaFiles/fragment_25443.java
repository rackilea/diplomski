@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class FooSpec extends Specification {

    @Autowired
    private CustomProperties customProperties;

    def "should read spring boot properties"() {

        when:
            def foo = customProperties.foo;
        then:
            foo
    }

}