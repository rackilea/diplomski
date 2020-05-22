public void go() throws Exception  {
Scanner kb = new Scanner(System.in);
ArrayList<Task> list = new ArrayList<Task>();
TaskManager taskMgr = new TaskManager();

System.out.println("Welcome to MyTaskManager");
while(true){
System.out.println("choose an option \n a: Add a new item \n b: Display tasks by date \n c: Display tasks by keyword \n q: quit");
System.out.println("Enter your choice");
String choice = kb.next();  
     if (choice.equalsIgnoreCase("a")) {
    taskMgr.makeTasks();
}
else if (choice.equalsIgnoreCase("b")) {
    System.out.println("enter the date you wish to view: ");
     SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    String date=kb.nextLine();
    Date dueDate = sdf.parse(date);
    taskMgr.findTasksByDate(dueDate);
     taskMgr.displayTaskReportByDate(dueDate);

}
else if (choice.equalsIgnoreCase("c")) {
    System.out.println(" Enter a keyword: ");
    String keyword=kb.nextLine();
    System.out.println("Task that contain the term "+keyword);
    taskMgr.findTasksByKeyword(keyword);
     taskMgr.displayTaskReportByKeyword(keyword);

}
else if (choice.equalsIgnoreCase("q")) {
    System.exit(0);
}
else {
     System.exit(0);
}
}
}