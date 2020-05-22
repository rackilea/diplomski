// In looping through files:
// Step 2:
BufferedReader r = new BufferedReader(new FileReader(f)); 
// Step 3:
String s = r.readLine();
while (s != null) {
    // Step 4:
    if (s.contains("TestString")) {
        // Step 5:
        System.out.println(f.getAbsolutePath());
        break;
    }
    s = r.readLine();
}
r.close();