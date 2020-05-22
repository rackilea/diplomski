public void openFile(){
    try {
        Appendable appendable = new FileWriter("income.txt",true);
        x = new Formatter(appendable);
    } catch(Exception e) {
        System.out.println("You have an error");
    }
}