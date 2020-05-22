FileInputStream fileInputStream = new FileInputStream(filename);
InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");      
BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
List<String> lines = new ArrayList<String>();
String line = null;
while ((line = bufferedReader.readLine()) != null) {
    lines.add(line);
}
bufferedReader.close();
System.out.println(lines.toArray(new String[lines.size()]));