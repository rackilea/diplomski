public static void main(String[] args) {

    try {
        Stock msft = new Stock("MSFT");
    } catch (IOException e) {
        //exception - do something
        e.printStackTrace();
    }
}