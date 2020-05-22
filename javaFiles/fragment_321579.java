public void changeName(Entry [] dogArray) {
    Scanner rp = new Scanner(System.in);
    for (int i = 0; i < dogArray.length; i++){
        String nameChange = rp.next();  {
        if(!dogArray[i].name.equals(nameChange)){
            dogArray[i].name = nameChange; 
        }
    }
}