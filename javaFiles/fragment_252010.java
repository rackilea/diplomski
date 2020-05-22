// Read File code line by line
    File file = new File("xyz.dat");
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

    List<String[]> list = new ArrayList<>();
    String line;
    while((line = br.readLine())!=null) {
        String[] str = line.split("~~");
        list.add(str);
    }

    // Traverse Code from List and Array
    for(String arr[] : list) {
        if(arr[1] == "") // write code as per your usage
    }