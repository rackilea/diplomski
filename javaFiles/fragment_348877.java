public List<Integer> read() throws IOException{
    File file = new File(n);

    List<Integer> list = new ArrayList<Integer>();
    try (Scanner in = new Scanner(file)) {
        while(in.hasNextInt()){
            list.add(in.nextInt());
        }
    }
    return list;
}