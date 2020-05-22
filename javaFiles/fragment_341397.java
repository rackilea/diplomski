File StudentGrade = new File("E:/workspace/Test/src/main/java/data.txt");
        Scanner reader = new Scanner(StudentGrade);
        int size = reader.nextInt();
        // debug: System.out.println(size);
        reader.nextLine();
    String[] gradeArr = new String[size];// array created for grades
    // debug: System.out.println(gradeArr);
    String[] nameArr = new String[size];// array created for name
    String[] temp = new String[100];// array created for temporary array
    int index = 0;// index indicator

    while (reader.hasNextLine()) {
        String s = reader.nextLine();
        // System.out.println(s);
        temp = s.split("\\s+");
        gradeArr[index] = temp[0];
        nameArr[index] = temp[1];
        System.out.println("grades= " + gradeArr[index] + " name = " + nameArr[index]);
        index++;
    }