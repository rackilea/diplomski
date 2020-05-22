List<Animal> animals=  new ArrayList<>();
List<Object> objects = new ArrayList<>();

List<? super Animal> contraVarianceList = animals;
List<? super Animal> contraVarianceList2 = objects;

animals.add(new Dog()); // Allowed
animals.add(new Tiger()); //Allowed

objects.add(new Dog()); // Allowed
objects.add(new Tiger()); //Allowed

//there is no type difference between contraVarianceList and contraVarianceList2
Animal animal = contraVarianceList.get(0);  //compiler will complain
Animal animal2 = contraVarianceList2.get(0); //compiler will complain