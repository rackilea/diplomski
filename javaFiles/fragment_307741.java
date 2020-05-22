public static void main(String args[]) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(3);
    list.add(4);
    list.add(56);
    list.add(6);

    for (int i = 0; i < 4; i++){
        String s = reader.readLine();
        list.add(Integer.parseInt(s));
    }

    for (int i = 0; i < list.size(); i++){
        if (list.get(i) > 5) {
            list.remove(i);
            i--;
        }
    }
    System.out.println(list);
}