recipeIngrediants = new boolean[numberOfCuisines][numberOfIngrediants];
int i = 0;
while(file.hasNextLine()){
    String temp = file.nextLine();
    String[] data = temp.split(",");
    for(int j=0; j < recipeIngrediants.length; j++){
        String c = data[j];
        recipeIngrediants[i][j] = (c != null) && (c.equals("1"));
    }
    i++;
}