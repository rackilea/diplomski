Process p = pb.start();  
// process runs in another thread parallel to this one

BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));

// bri may be empty or incomplete.
while ((line = bri.readLine()) != null) {
    RESULT+=line;
}