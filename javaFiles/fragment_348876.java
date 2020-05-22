public List<Integer> read() throws IOException{
    File file = new File(n);
    Scanner in = new Scanner(file);

    List<Integer> list = new ArrayList<Integer>();
    while(in.hasNextLine()){
        String line = in.nextLine();

        Scanner scan = new Scanner(line);
        while(scan.hasNextInt()){
            list.add(scan.nextInt());
        }

        scan.close();
    }
    in.close();
    return list;
}