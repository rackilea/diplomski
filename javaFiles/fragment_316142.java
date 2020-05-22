Scanner input = new Scanner(file);
TreeMap<Integer, String> valores = new TreeMap();
     while(input.hasNextLine()){

        String line = input.nextLine();
        String[] divline = line.split(" ");           

        if(!divline[1].equals("apply")){
            valores.put(Integer.valueOf(divline[0]), divline[1]);   
        } else {
            valores.put(Integer.valueOf(divline[0]), divline[1]);
            break;
        }             

    }

for (Entry<Integer,String> entry: valores){
   System.out.println(entry.getKey() + "- "+entry.getValue());
}