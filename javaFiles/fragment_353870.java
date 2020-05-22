String ussdCode = "*123#";
Intent intent = new Intent(Intent.ACTION_CALL);
intent.setData(ussdToCallableUri(ussdCode));
try{
    startActivity(intent);
} catch (SecurityException e){
    e.printStackTrace();
}