Thread runningThread = new Thread() {
  @Override
  public void run() {
    String[] cmdArray = new String[3];
    cmdArray[0] = "mysqld.exe";
    cmdArray[1] = "--defaults-file=./my.ini";
    cmdArray[2] = "--console";
    try {
      Process proc = Runtime.getRuntime().exec(cmdArray);

      // read results
      BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }

      br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
      try {
        proc.waitFor();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
};
runningThread.start();
while(!isMySQLRunning()) {
  System.out.println("waiting for MySQL to start...");
}

// ...

private static boolean isMySQLRunning() {
  String[] cmdArray = new String[7];
  cmdArray[0] = "mysqladmin.exe";
  cmdArray[1] = "-u";
  cmdArray[2] = "root";
  cmdArray[3] = "-pMyPassord";
  cmdArray[4] = "-P";
  cmdArray[5] = "3306";
  cmdArray[6] = "status";
  Vector<String> res = runCommand(cmdArray); // runCommand(): see above
  if (res.size() > 0 && res.get(0).contains("Can't connect to MySQL server")) {
    System.out.println("MySQLis not running.");
    return false;
  } else if (res.size() > 0 && res.get(0).contains("Uptime")) {
    System.out.println("MySQLis running.");
    return true;
  }
  System.out.println("MySQLis not running.");
  return false;
}