SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    ProjectFile file = new ProjectFile();
    ProjectHeader header = file.getProjectHeader();
    header.setStartDate(df.parse("01/05/2014"));

    Task task1 = file.addTask();
    task1.setName("Summary Task");

    Task task2 = task1.addTask();
    task2.setName("First Sub Task");
    task2.setDuration(Duration.getInstance(10.5, TimeUnit.HOURS));
    task2.setStart(df.parse("01/05/2014"));
    task2.setPercentageComplete(NumberUtility.getDouble(50.0));

    Task task3 = task1.addTask();
    task3.setName("Second Sub Task");
    task3.setStart(df.parse("11/05/2014"));
    task3.setDuration(Duration.getInstance(10, TimeUnit.HOURS));

    Task milestone1 = task1.addTask();
    milestone1.setName("Milestone");
    milestone1.setStart(df.parse("21/05/2014"));
    milestone1.setDuration(Duration.getInstance(0, TimeUnit.HOURS));

    Task task4 = file.addTask();
    task4.setName("Last Task");
    task4.setDuration(Duration.getInstance(8, TimeUnit.HOURS));
    task4.setStart(df.parse("02/05/2014"));
    task4.setPercentageComplete(NumberUtility.getDouble(70.0));

    ProjectWriter writer = getWriter(filename);
    writer.write(file, filename);