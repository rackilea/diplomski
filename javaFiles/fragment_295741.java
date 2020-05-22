Person foo = new Person();
foo.setName("Foo");
foo.setId("1");

List<Car> cars = new ArrayList<Car>();
Car subaru = new Car();
subaru.setName("Subaru");
subaru.setModel("Imprezza");
cars.add(subaru);
foo.setCar(cars);