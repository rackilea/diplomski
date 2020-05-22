FileInputStream fileInputStream = new FileInputStream("data.txt");
File outputFile = new File("out.txt");
PrintWriter writer = new PrintWriter(outputFile, "UTF-8");
BufferedReader bf = new BufferedReader(new InputStreamReader(fileInputStream));
int count = 1;
String out;
Pattern pattern = Pattern.compile(":\\[((\\d\\.\\d+(,\\s)?){0,4})\\]$");

while ((out = bf.readLine()) != null){
    Matcher matcher = pattern.matcher(out);
    if (matcher.find()){
        String capture = count + ". " + matcher.group(1);
        writer.println(capture);
        System.out.println(capture);
        count++;
    }
}
fileInputStream.close();
writer.close();