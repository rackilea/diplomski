public void read() throws IOException {
    List<ArrayList<String>> mylist = new ArrayList<ArrayList<String>>();
    FileReader fr = new FileReader("/Users/home/Documents/input.txt");
    BufferedReader br = new BufferedReader(fr);
    String line;
    int current_line = 0; 
    int cnt = 0;

    while ((line = br.readLine()) != null) {
        String arr[];
        arr = line.split("\t");
        mylist.add(new ArrayList<String>());
        for(int i = 0; i < arr.length; i++){
            mylist.get(cnt).add(arr[i]);
            if(mylist.get(cnt).get(i).equals("<<")) 
                current_line = cnt;
        }
        cnt++;
    }
    br.close();
}