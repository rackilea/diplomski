for(int i = 0; i < Lol.size(); i++) { // Iterate over Lol
    if(i == 2) { // If you want to update the elements of the List present at index 2
         // Do what you want - Below is just an example and isn't that very robust
        Lol.get(i).set(0, "String 1");
        Lol.get(i).set(3, "String 2");
        Lol.get(i).set(6, "String 3");
    }
}