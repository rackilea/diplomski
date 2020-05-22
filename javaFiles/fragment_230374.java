public static void main(String args[]) throws IOException {    
    String file="C:\\Users\\Dhananjay Kumar\\Empdetail\\Detail.csv";
    HashMap<String,Integer> hashfunc=new HashMap<String,Integer>(); // !!!
    CSVReader reader=new CSVReader(new FileReader(file));
    String[] read;
    while((read = reader.readNext()) !=null) {
        haschfunc.put(read[0], Integer.parseInt(read[2])); // !!!
    }   
    for (Entry entry : hashfunc.entrySet()) {
        System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());           
    }   
}