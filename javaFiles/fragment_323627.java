class HashClash {
    public static void main(String[] args) {
        final Object obj = new Object();
        final int target = obj.hashCode();
        Object clash;
        long ct = 0;
        do {
            clash = new Object();
            ++ct;
        } while (clash.hashCode() != target && ct<10L*1000*1000*1000L);
        if (clash.hashCode() == target) {
            System.out.println(ct+": "+obj+" - "+clash);
        } else {
            System.out.println("No clashes found");
        }
    }
}