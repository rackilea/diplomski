double[][] mark = new double[assignmentLimit][studentLimit];
    for (index = 0; index < assignmentLimit; index++)
    {
        System.out.println("\nAssigment " + (index + 1) + " marks:");
        for (int studentMark = 0; studentMark < studentLimit; studentMark++)
        {
            System.out.print("\nStudent " + (studentMark + 1) + ": ");
            mark[index][studentMark] = Integer.parseInt(console.readLine());
        } // end of for(int index = 0; index < ARRAY_LIMIT; index++)
    }

    for (index = 0; index < studentLimit; index++)
    {  
        System.out.println("\nStudent " + (index + 1) + " marks");
        for (int studentMark = 0; studentMark < assignmentLimit; studentMark++)
        {
            System.out.println("\t" + mark[studentMark][index]); // mark[studentMark][index] but not mark[index][studentMark]
        }
    }