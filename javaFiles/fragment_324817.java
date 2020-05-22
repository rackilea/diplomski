//Creates the builder object 
Builder builder = Package.Foo.newBuilder();
//populate the repeated field.
builder.addAll(new ArrayList<Bar>());
//This should build out a Foo object
builder.build();