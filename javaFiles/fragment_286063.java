public static void main(String[] args){
    try{
        Scanner scanner = new Scanner(new File("testFile.txt"));
        List<String> list = new ArrayList<String>();
        while(scanner.hasNext()){
            String s = scanner.next();
            list.add(s);
        }
        scanner.close();

        System.out.println(list);
    }catch(FileNotFoundException e){
          e.printStackTrace();
    }
}