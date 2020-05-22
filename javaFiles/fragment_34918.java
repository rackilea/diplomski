public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(strOrFile).useDelimiter(",| ");
    List<Integer> myList = new ArrayList<Integer>();
    while (s.hasNext()) {
       myList.add(s.nextInt());
    }
}