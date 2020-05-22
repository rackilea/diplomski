List<? extends Animal> fooList = new ArrayList<>();
List<Dog> barList = new ArrayList<>();
barList.add(new Dog());
barList.add(new Dog());
barList.add(new Dog());
barList.add(new Dog());

fooList = barList;