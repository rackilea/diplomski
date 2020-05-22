public static void main(String args[]) {
    //array for the 6 students
    Students[] student = new Students[6];
    //creating and adding one by one
    Students sam = new Students("Sam", "Wo", 22);
    student[0] = sam;
    Students ben = new Students("Ben", "Wang", 27);
    student[1] = ben;
    Students arsalan = new Students("Arsalan", "Khan", 28);
    student[2] = arsalan;
    Students issa = new Students("Issa", "Hashim", 25);
    student[3] = issa;
    //ben khan will test if the last name is different. Should be fun .
    Students benK = new Students("Ben", "Khan", 29);
    student[4] = benK;
    Students jackM = new Students("Jack", "Meth", 23);
    student[5] = jackM;

    Arrays.sort(student);

}