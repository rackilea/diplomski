String[] cmd = new String[] {
    "java",
    "-cp",
    "fitnesse.jar:\"/home/stewart/white space test/example-1.0.0-SNAPSHOT/target/test-classes\":\"/home/stewart/white space test/example-1.0.0-SNAPSHOT/target/classes\":/home/stewart/.m2/repository/org/fitnesse/fitnesse/20121220/fitnesse-20121220.jar",
    "fit.FitServer",
    "linux-desktop",
    "9123",
    "10";
};
String[] env = new String[]{};
Runtime.getRuntime().exec(cmd, env);