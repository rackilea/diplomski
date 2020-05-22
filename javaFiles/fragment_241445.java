public class NewClass {
    final String userName = "myuser";
    final String myPassword = "password";
    public NewClass () {
      String[] myCommandWithParams=new String[4];
      myCommandWithParams[0]="sqlplus";
      myCommandWithParams[1]="USERID="+userName+"/"+myPassword;
      myCommandWithParams[2]="TABLES=(hr.students)";
      myCommandWithParams[3]="FILE=exp_tab.dmp";
      Runtime runtime = Runtime.getRuntime();
      try {
          runtime.exec(myCommandWithParams);
      } catch (SecurityException | IOException ex) {
          System.err.println("There is a problem for executing the command");
      } catch (IndexOutOfBoundsException ex) {
           System.err.println("myCommandWithParams can't be empty");
      }
    }
}