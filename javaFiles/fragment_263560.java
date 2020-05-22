String sCurrentLine = null;
BufferedReader br = new BufferedReader(new FileReader("/home/shubham/git/productApi"));
ArrayList<String> list = new ArrayList<String>();

while ((sCurrentLine = br.readLine()) != null) {
    list.add(sCurrentLine);
}

br.close();

request.payload = String.join(System.getProperty("line.separator"), list);
System.out.println("dd =" + request.payload);