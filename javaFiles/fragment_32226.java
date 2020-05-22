PrintStream ps = new PrintStream(out);
DateFormat df = new SimpleDateFormat("EEE, MMM d, yyyy HH:mm:ss z");
ps.println("HTTP/1.1 200 OK");
ps.println("Content-Type: text/html; charset=UTF-8");
ps.println("Date: " + df.format(new Date()));
ps.println("Connection: close");
ps.println();
ps.println(HTMLCode);