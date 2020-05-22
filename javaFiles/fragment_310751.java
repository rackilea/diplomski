try {
String oldFile = "oldFileNname";
String newFile = "newFileName";
PrintWriter f = new PrintWriter(new FileWriter(newFile));


BufferedReader br = new BufferedReader(new FileReader(oldFile));
String line;
while ((line = br.readLine()) != null) {

    if (line.equals("socialspy: true")) {
        f.println("socialspy: false");
    }
    else {
        f.println(line);
    }
}
br.close();
f.close();
}catch (IOException e) {
    //OMG Exception again!
}