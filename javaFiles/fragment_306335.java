String []result;
String returnValue:
                    file = new FileReader(filename);
            reader = new BufferedReader(file);
            String line = "";
            while ((line = reader.readLine()) != null) {
                returnValue += line + "\n";
            }
            result = returnValue.split("\\s+");
    for(String t1: result){
    Pattern = Pattern.compile("\\b:[0-9]\\b");
                    matcher = pattern.matcher(t1);
                    if(matcher.find()){
                        System.out.println(t1);
    }