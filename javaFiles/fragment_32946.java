Scanner scan = new Scanner(new FileReader(new File("hurcdata2.txt")));
    List<Integer> year = new ArrayList<Integer>();
    List<String> month = new ArrayList<String>();
    List<Integer> windspeed = new ArrayList<Integer>();
    List<Integer> pressure = new ArrayList<Integer>();
    List<String> name = new ArrayList<String>();
    List<Integer> category = new ArrayList<Integer>();

    while(scan.hasNext()){
        String input = scan.nextLine();
        String[] hurricane = input.split("\\s+");
        year.add(Integer.parseInt(hurricane[0]));
        month.add(hurricane[1].trim());
        windspeed.add(Integer.parseInt(hurricane[2]));
        pressure.add(Integer.parseInt(hurricane[3]));
        name.add(hurricane[4].trim());
        category.add(Integer.parseInt(hurricane[5]));
    }

    int sum = 0;
    for(Integer integer : pressure){
        sum += integer.intValue();
    }

    double average = sum / pressure.size();
    //System.out.println(average);
}