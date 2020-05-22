private static int oldNumber = -1;
private void checkMMSRows(){
    Cursor curPdu = getContentResolver().query(Uri.parse("content://mms/part"), null, null, null, null);
    if (curPdu.moveToNext()){
        int number = curPdu.getCount();
        System.out.println(number);
        if(number != oldNumber){
            System.out.println("Changed");
            // add any code here that you want to react to the change
        }
        oldNumber = number;
    }
}