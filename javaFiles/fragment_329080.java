public static void main(String[] args) throws Exception {
    TreeSet<Integer> numbers=new TreeSet<>();
    FileReader fr=new FileReader("numbers.txt");
    BufferedReader br=new BufferedReader(fr);
    String line;
    while((line=br.readLine())!=null){
        numbers.add(Integer.parseInt(line));
    }
    br.close();
    Iterator<Integer> it=numbers.iterator();
    while(it.hasNext()){
        System.out.println(it.next());
    }
    //PrintWriter pw=new PrintWriter("result.txt");
    //while(it.hasNext()){
    //  pw.println(it.next());
    //}
    //pw.close();
}