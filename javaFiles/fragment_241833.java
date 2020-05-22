public boolean save(Bill bill) {
    System.out.println("Entering the Store BillInfo method");
    boolean result = false;
    try {
       //..... saving logic
       result = true;
    }
    catch(Exception e) {
        result = false;
        e.printStackTrace();
    }
    return result;
}