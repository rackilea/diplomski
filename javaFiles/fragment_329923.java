for(int row = 0; row < animalFood.length; row++){
    System.out.print("Enter an animal name: ");
    animalFood[row][0] = in.nextLine();
    System.out.print("Enter the foods the animal eats: ");
    //all of the foods separated by commas
    String[] foods = in.nextLine().split(",");
    for(int i = 0; i < foods.length; i++) {
        animalFood[row][i + 1] = foods[i];
    }
}