try {
    try (Bum bum = new Bum()) {
        bum.bu();
    }
} catch (Exception ex){
    System.out.println("Exception");
    //ex.printStackTrace();
}