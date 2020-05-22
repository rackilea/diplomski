public static Grades sort(Grades mergedGrades, Grades repeat) {
    Grades sortedGrades = new Grades();
    Grade highComp = null;
    Grade highest = mergedGrades.get(0);
    int index = 0;

    while (mergedGrades.size() > 0) {        
        for (int j = 0; j < mergedGrades.size(); j++) {
            highComp = mergedGrades.get(j);
            if (highComp.getGpa() > highest.getGpa()) {
                highest = highComp;
                //debug: System.out.println("getGpa: "+highest.getGpa());
                index = j;
            }
         }
         sortedGrades.add(highest);
         mergedGrades.remove(index);
     }
}