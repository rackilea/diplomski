public void read(List<Integer> list) throws IOException{
    File file = new File(n);
    try (Scanner in = new Scanner(file)) {
        while(in.hasNextInt()){
            list.add(in.nextInt());
        }
    }
}