DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
Date date = new Date();
String timeAndDate = dateFormat.format(date);

File file = new File("backups/"+timeAndDate);
file.mkdirs();

try {

    String command = "mongoexport --db cookbook --collection foo --out \"backups/"+ timeAndDate + "/foos.json\"";

    Process p = Runtime.getRuntime().exec(command);
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));

    while(reader.ready())
    {
        System.out.println(reader.readLine());
    }

    System.in.read();

} catch (IOException e) {
    e.printStackTrace();
}