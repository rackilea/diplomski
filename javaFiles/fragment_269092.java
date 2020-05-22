public static void alertUser(String str) {

runOnUiThread(setErrorMessage); 

}


private Runnable setErrorMessage = new Runnable() {
    @Override
    public void run() {

        Toast toast = Toast.makeText(mInstance.getApplicationContext(), str,
        Toast.LENGTH_LONG);
toast.show();
    }
};