public void customPrint(String inputToPrint){
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date now = new Date();
    String strDate = sdfDate.format(now);
    System.out.println("[" + strDate + "] " + inputToPrint);
}