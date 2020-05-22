URL url = new URL(surl);
HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();       
InputStream isr = httpcon.getInputStream();
try (BufferedReader bw = new BufferedReader(new InputStreamReader(isr, "utf-8"))) {
    StringBuilder sb = new StringBuilder();
    String line;
    while ((line = bw.readLine()) != null) { // read whole response
        sb.append(line);
    }
    System.out.println(sb); //Output whole response into console or use logger of your choice instead of System.out.println
}