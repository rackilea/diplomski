void salesData() throws IOException {
    System.out.print("Enter Name: ");
    name = stdin.readLine();
    if (name.equalsIgnoreCase("done")) {
        rptOut();
        return;
    }
    // ... processing ...
 }