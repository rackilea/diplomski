public class SomeInterfaceImplementation implements SomeInterface<Foo> {

    @Override
    public void addAThing(Foo thing) {
      // thing is of type Foo
    }

    @Override
    public void addAListOfThings(Collection<Foo> things) {
      // things is a collection of Foo
    }
}