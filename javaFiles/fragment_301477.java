public static final int FILE_TYPE = 0;
public static final int INT_TYPE = 1;
public static final int STRING_TYPE = 2;

taskargs = new Object[] { "mystring", new File("somefile.txt"), new myObject("somearg") };

new Task(STRING_TYPE, taskargs).execute();