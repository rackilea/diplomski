String findProcess = "chrome.exe";
String filenameFilter = "/nh /fi \"Imagename eq "+findProcess+"\"";
String tasksCmd = System.getenv("windir") +"/system32/tasklist.exe "+filenameFilter;

Process p = Runtime.getRuntime().exec(tasksCmd);
BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

ArrayList<String> procs = new ArrayList<String>();
String line = null;
while ((line = input.readLine()) != null) 
    procs.add(line);

input.close();

Boolean processFound = procs.stream().filter(row -> row.indexOf(findProcess) > -1).count() > 0;
// Head-up! If no processes were found - we still get: 
// "INFO: No tasks are running which match the specified criteria."