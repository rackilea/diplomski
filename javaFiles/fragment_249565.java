userInputFile = new BufferedReader(new FileReader(userDocFilePath));
Animal newFileAnimal = null;

while((s = userInputFile.readLine()) != null) {    
    newFileAnimal = new Animal();                                            
    if (ctr == 1){
        newFileAnimal.setName(s);
        ctr++;
    } else if (ctr == 2) {
        newFileAnimal.setSpineStatus(s);
        ctr++;
    } else if (ctr == 3) {
        newFileAnimal.setFurStatus(s);
        ctr++;
    } else if (ctr == 4) {
        newFileAnimal.setSwimStatus(s);
        System.out.printf("Animal name: %s\n\tSpine status: %s\n\t"
            + "Fur status: %s\n\tSwim status: %s\n", Animal.getName(), 
            + newFileAnimal.getSpineStatus(), 
            + newFileAnimal.getFurStatus(),
            + newFileAnimal.getSwimStatus());
        array.add(newFileAnimal);
        ctr = 1;
    }
}