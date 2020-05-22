public static void main(String args[]){
        int month = 6;
        Calendar cal  = Calendar.getInstance();
        cal.set(Calendar.MONTH, month-1);
        System.out.println(cal.getActualMaximum(Calendar.DATE));
    }