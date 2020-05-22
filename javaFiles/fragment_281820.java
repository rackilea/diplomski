Animal someAnimal;

switch (operacion) {
    case 1:
        someAnimal = new Perro();
        break;
    case 2:
        someAnimal = new Gato();
        break;
    case 3:
        someAnimal = new Tigre();
        break;
}

System.out.println(someAnimal.toString());
System.out.println(someAnimal.hablar());
System.out.println(someAnimal.giveFood(food));