class Impl {
     @Inject public ISoap soap; // requires field injection
}

// will only work with something like this
Impl myImpl new Impl();
component.inject(myImpl); // inject fields