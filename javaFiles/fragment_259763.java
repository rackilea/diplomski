BufferedReader reader = new BufferedReader(new FileReader(myLog));
String line;
while((line = reader.readLine()) != null) {
    lastLines.add(0, line);
    if(lastLines.size() > 5)
        lastLines.remove(5);
}

// lastLines will have your five lines in reversed order
System.out.println(lastLines);