public class test1 {

    public static void main(String args[]) throws IOException{

        StringBuffer sb = new StringBuffer();
        String filepath = "test.txt";
        List<String> list = new ArrayList<String>(); 
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");

        Iterator<String> it = list.iterator();
        while(it.hasNext())
        {
            sb.append(it.next());
            sb.append(",");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}