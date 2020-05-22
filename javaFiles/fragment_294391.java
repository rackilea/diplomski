public static void getLogCatDetails() {
                try {

                    Process process = Runtime.getRuntime().exec("logcat -d");

                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(process.getInputStream()));

                    StringBuilder log = new StringBuilder();

                    String line = "";

                    while ((line = bufferedReader.readLine()) != null) {
                        log.append(line);
                    }
}
catch (Exception e) {
        e.printStackTrace();
       }
        }

public static void clearLog()
    {
      try
      {
        Runtime.getRuntime().exec("logcat -c");
      }
      catch (Exception e) {
        e.printStackTrace();
       }
    }