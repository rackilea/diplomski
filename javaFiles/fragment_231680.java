public static void printRows(String id, String desc, int fee) {
    System.out.printf("\n| %s | %-20.20s| %,8d|", id, desc, fee);
    while(desc.length()>20){
        desc=desc.substring(20);
        System.out.printf("\n|   | %-20.20s|         |", desc);
    }
    System.out.printf("\n---------------------------------------");
}