System.out.println("How many pets are there?");
i = s.nextInt();
PetRecord[] array = new PetRecord[i];

for (int k = 0; k < array.length; k++){
    System.out.println("Please give the names of the pets: ");
    array[k] = new PetRecord(s.nextLine());
}