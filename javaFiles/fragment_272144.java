public class Test {

    public static void main(String[] args) {
         EmployeeRecord emp = new EmployeeRecord("John");
         Table<EmployeeRecord> tab = new Table<EmployeeRecord>();
         tab.set( emp );
         tab.printAll();
    }
}