String line = "";
List<Integer> tall = new ArrayList<Integer>();
try {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    while ((line = br.readLine())!= null) {
        tall.add(Integer.parseInt(line, 2));
    }
    br.close();
}catch(IOException e) {}