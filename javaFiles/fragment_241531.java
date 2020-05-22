public static void main(String[] args) {

        Student studentArray[] = new Student[5];

        studentArray[0] = new Student(5555, "Jim Jackson");
        studentArray[1] = new Student(4444, "Craig Creedmor");
        studentArray[2] = new Student(3333, "Bill Biggums");
        studentArray[3] = new Student(2222, "Frances Freeland");
        studentArray[4] = new Student(1111, "Leslie Limerick");

        sort(studentArray);

        for (int i = 0; i<5; i++) {
        System.out.println(studentArray[i].toString());
        }

    }

    public static void sort(Student[] arr) {
         for (int i = 0; i < arr.length - 1; i++)
            {
                int index = i;
                for (int j = i + 1; j < arr.length; j++)
                    if (arr[j].getID() < arr[index].getID()) 
                        index = j;

                int smallerNumber = arr[index].getID();
                String smallerString = arr[index].getName();
                arr[index].setID(arr[i].getID());
                arr[index].setName(arr[i].getName());
                arr[i].setID(smallerNumber);
                arr[i].setName(smallerString);
            }

}