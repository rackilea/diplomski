{
    int lineLength;
    lineLength = lineFinder(names);

    System.out.printf("%30s %14s %14s", "NAME", "ID", "GPA");
    System.out.println();
    for(int i = 0; i < lineLength; i++)
    {
        System.out.printf("%30s %-14d %14.2f", names[i] , id[i], gpa[i]);
        System.out.println();

    }

}