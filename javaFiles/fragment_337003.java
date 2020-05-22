String[][] students = { { "Carol McKane", "James Eriol", "Elainee Black" }, { "920", "154", "462" } };


    for (int i = 0 ; i < students[0].length; i++) {
        System.out.println(students[0][i] + "\t" + students[1][i] + "\t" + students[0][i].replace( " ", "" ).length() );
    }