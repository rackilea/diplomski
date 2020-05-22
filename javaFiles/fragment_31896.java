String phone;
    phone = "38495";
    System.out.println("this is the phone: " + phone);

    BufferedReader line = new BufferedReader(new FileReader(new File("list.txt")));
    String indata;

    ArrayList<String[]> dataArr = new ArrayList<>();
    String[] club = new String[2];
    String[] value;// = indata.split(",", 2);
    while ((indata = line.readLine()) != null) {
        value = indata.split(",");
        dataArr.add(value);
    }
    int j = 0;
    for (int i = 0; i < dataArr.size(); i++) {
        String[] phoneData = dataArr.get(i);
        if (phoneData[1].equals(phone)) {
            System.out.println("Found number.");
            club[j++] = phoneData[1];
            break;
        } else if (i == dataArr.size()-1) {
            System.out.println("Didn't find number.");
        }
    }