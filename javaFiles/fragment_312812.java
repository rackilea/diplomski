public double computeGPA(ArrayList<Course> courseTaken) {
    double cGPA;
    double tUnits = 00;
    double tGrade = 00;

    for(int y=0; y<courseTaken.size(); y++) {
        tUnits += courseTaken.get(y).getCUnits();
    }

    for(int x=0; x<courseTaken.size(); x++) {
        if(courseTaken.get(x).getCGrade()>=97) 
            tGrade += courseTaken.get(x).getCUnits()*4;
         else if(courseTaken.get(x).getCGrade()>=93 && courseTaken.get(x).getCGrade()<=96) 
            tGrade += courseTaken.get(x).getCUnits()*3.5;
         else if(courseTaken.get(x).getCGrade()>=89 && courseTaken.get(x).getCGrade()<=92) 
            tGrade += courseTaken.get(x).getCUnits()*3;
         else if(courseTaken.get(x).getCGrade()>=85 && courseTaken.get(x).getCGrade()<=88) 
            tGrade += courseTaken.get(x).getCUnits()*2.5;
         else if(courseTaken.get(x).getCGrade()>=80 && courseTaken.get(x).getCGrade()<=84) 
            tGrade += courseTaken.get(x).getCUnits()*2;
         else if(courseTaken.get(x).getCGrade()>=75 && courseTaken.get(x).getCGrade()<=79) 
            tGrade += courseTaken.get(x).getCUnits()*1.5;
         else if(courseTaken.get(x).getCGrade()>=70 && courseTaken.get(x).getCGrade()<=74) 
            tGrade += courseTaken.get(x).getCUnits()*1;
         else 
            tGrade += courseTaken.get(x).getCUnits()*0;

    }
    cGPA = tGrade/tUnits;

return cGPA;
}//computeGPA