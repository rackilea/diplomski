try {
    Bum bum = new Bum();
    try {
        bum.bu();
    } finally {
        // It's more complicated than this...
        bum.close();
    }
} catch (Exception ex){
    System.out.println("Exception");
    //ex.printStackTrace();
}