try (PrintWriter writer = new PrintWriter(System.out)) {
    Bank hsbc = new Bank();
    ...
} catch(Exception e){
    // writer will already be closed here
    e.printStackTrace(); 
}