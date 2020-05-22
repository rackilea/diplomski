public static void allRecords() throws Exception 
 {
    int size = studentList.size();
    for (int i=0; i<size; i++) {
        System.out.printf("%-5d %10s %10s %15d\n", studentList.get(i).returnId(), studentList.get(i).returnFirst(), studentList.get(i).returnLast(), studentList.get(i).returnGrad());
    }
}