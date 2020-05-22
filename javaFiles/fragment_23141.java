Set<String> rows = new HashSet<String>(); 

String line = null;
while((line = reader.readLine()) != null){
    if(!rows.add(line.substring(0, line.lastIndexOf(','))))
        System.out.println("duplicate found: " + line);
}