private ArrayList<String> epurateInformation(ArrayList<String> list) {
    String[] potentialThreat = {"Pret : ", "Nom de l'Album : ", "Style : ", "Date : ", "Nom de la piste : ", "Propriétaire : ", "Information : "};

    for(String s : list) {
        for(int i = 0; i < potentialThreat.length; i++) {
            System.out.println(potentialThreat[i]);
            //The error is right below here
            if(s.contains(potentialThreat[i])) {
                s.replace(potentialThreat[i], "");
            }
            cdInformation.add(s);
        }
    }

    return list;
}