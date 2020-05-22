for (int i = 0; i < animalFood.length; i++) {
     arrayItem = animalFood[i][0];
     arrayItem = arrayItem.toUpperCase();
     if(arrayItem.equals(itemToMatch)){ 
        matchResult = "The animal " + name + " was found in the zoo! It eats ";
        //Iterates over the foods it eats
        for(int j = 1; j < animalFood[i].length; j++) {
            //If this is the last food in the list
            if(j == animalFood[i].length - 1) {
                matchResult += "and " + animalFood[i][j] + ".";
            }
            else {
                matchResult += animalFood[i][j] + ", ";
            }
        }        
     }
     else {
        //nothing found
     }      
}