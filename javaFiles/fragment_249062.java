public void addAnimal(Animal a){
    if ((numberanimals < animals.length) && (numberanimals == 0)) {
        animals[0] = a;
        numberanimals += 1;
    } else if (numberanimals < animals.length) {
        animals[numberanimals] = a;
        numberanimals += 1;
        } else {
            System.out.println("Zoo is full.");
        }
    }
}