public static void main(String[] args) {
    Task myTask = new Task();
    myTask.setDate("02\\03\\20");
    System.out.println(myTask.dateIsValid());
    Task myTask2 = new Task();
    myTask2.setDate("23\\45\\6001");
    System.out.println(myTask2.dateIsValid());
}