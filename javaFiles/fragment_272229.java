Animal animal = new Animal();

Bird bird = new Bird();

Animal birdAnimal = new Bird();

if (animal.getClass() == bird.getClass()){
    System.out.println("Bird equals to animal");
}else{
    System.out.println("Bird not equals to animal");
}

if (birdAnimal.getClass() == animal.getClass()){
    System.out.println("BirdAnimal equals to animal");
}else {
    System.out.println("BirdAnimal not equals to animal");
}

if (animal.getClass() == Animal.class){
    System.out.println("animal equals to Animal");
}else{
    System.out.println("animal not equals to Animal");
}

if (animal.getClass() == Bird.class){
    System.out.println("animal equals to Bird");
}else{
    System.out.println("animal not equals to Bird");
}