public static void main(String args[]) { 
    ArrayList storeWord = new ArrayList();
    Scanner scannerWord = new Scanner(new File("word"));

    while(scannerWord.hasNext()) {
        storeWord.add(scannerWord.next());
    }

    Iterator itr = storeWord.iterator();
    while(itr.hasNext()){
       System.out.println(itr.next());
    }
}