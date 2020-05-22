@Parameters
public static Collection<Object[]> data() throws IOException{
    Scanner s = new Scanner(new File("/home/users/me/myfile"));
    ArrayList<Object[]> list = new ArrayList<Object[]>();
    while (s.hasNext()){
        list.add(new Object[] { s.next() });
    }
    s.close();
    return list;
}