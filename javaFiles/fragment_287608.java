public static String reportgrades() //this is grade sorted by name 
    {

    String[] grades = {"Evans", "Smith", "Adams", "Hashimoto", 
    "Stimson", "Velasquez", "Lamarque", "Vang", "Creswell", "Yee"};
    String output = "Sorted by name ";
    int in, out;
    String temp; //this is to hold the orginal variable. 
    //for the first letter cycle
    long nElems = grades.length; 
    for (out = 1; out < nElems; out++) {
        in = out;
        while (in > 0 &&  0 < (grades[in - 1].compareTo(grades[in]))) {
            temp = grades[in];
            grades[in] = grades[in-1];
            grades[in-1] = temp;
            in--;
        }    
    }
    for (int j = 0; j < nElems; j++) {
         output += grades[j] + ", ";
    }
    return output;
}