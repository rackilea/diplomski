java.util.Random r = new java.util.Random();
    java.util.Scanner  s = new java.util.Scanner(System.in);
    int arraylength = s.nextInt();
    int students[] = new int[arraylength];
    for(int i =0;i< arraylength;i++)
    {
        students[i]=i;
        System.out.println(students[i]);
    }
    System.out.println("generated");
    int no_of_selected_students = r.nextInt(arraylength);
    int selected_students[] = new int[no_of_selected_students];
    int last =no_of_selected_students;
    for(int i=0;i<no_of_selected_students;i++)
    {
        int current = r.nextInt(last);
        selected_students[i] = students[current];
        students[current]= students[last];
        last--;
        System.out.println(selected_students[i]);
    }
    System.out.println("randomized");