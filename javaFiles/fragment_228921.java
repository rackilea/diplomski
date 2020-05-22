public static Student[] createArray() {

    System.out.println("Enter size of array:");
    Scanner userInputEntry = new Scanner(System.in);
    int inputLength =userInputEntry.nextInt();
    Student students[] = new Student[inputLength];

    return students; 

    }

public static void populateArray(Student [] array) {
    for(int i=0;i<array.length().i++)
    {
       array[i]=new Student();
       System.out.println("Enter Name");
         Scanner userInputEntry = new Scanner(System.in);
       array[i].setName(userInputEntry .next());
       System.out.println("Enter Id");
       array[i].setIdNumber(userInputEntry .nextLong());
    }
}