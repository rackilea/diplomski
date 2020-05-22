public static void main(String[] args) {
    Console console = System.console();
    if(console!=null){
        System.out.println("Console is not null");
    }else{
        System.out.println("Console is null");
    }
}