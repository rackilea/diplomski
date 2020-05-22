for(int i = 0 ; i < str.length;i++){//pour chaque ligne 
    String str2 [] = str[i].split(":");
    String NomMolecule = str2[0];
    String diese [] = str2[1].split("#");
    String description [] = diese[0].trim().split(" ");
    HashMap<String,Integer> dictionnaire1 = new HashMap<>();
    for( int j = 0; j < description.length; j += 2 ){
        int nb = Integer.parseInt(description[j+1]);
        dictionnaire1.put(description[j], nb);
    }
    dictionnaire2.put(NomMolecule,dictionnaire1);
}