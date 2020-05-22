class CaseWithInheritance extends Specification{
    @TypeName("A")
    class A {
        @Id
        String id
        String field
    }
    @TypeName("A")
    class B extends A {
        @DiffIgnore
        String someOtherField
    }

    def "should compare objects' intersection"(){
      given:
      def a = new A(id:1, field:"aa")
      def b = new B(id:1, field:"bb", someOtherField:"b")
      def javers = JaversBuilder.javers().build()

      when:
      def diff = javers.compare(a, b)

      then:
      diff.changes.size() == 1
      println diff.prettyPrint()
    }
}