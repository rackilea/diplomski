BufferedReader br =new BufferedReader(new FileReader("userdetails.txt"));
    String str;
    ArrayList<String> stringList = new ArrayList<String>();
    while ((str=br.readLine())!=null){
        int firstIndexOfComma = str.indexOf(',');
        String category = str.substring(0, firstIndexOfComma);
        String value = str.substring(firstIndexOfComma + 1);
        stringList.add(category);
        stringList.add(value);
        System.out.println(category+" "+value);
    }
    br.close();