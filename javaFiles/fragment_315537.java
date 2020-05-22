for(int i = 0; i < students.size(); i++) { // iterate over the students to find the one
                                           // having the required name
    if(students.get(i).getName().equals("Garrett M")){
        // iterate over the choices of the found student and collect them into the array
        for (int j = 0; j < students.get(i).getChoices().size; j++) {
            myChoices[j] = students.get(i).getChoices().get(j);
        }
        break;
    }
}