class AndroidUtils{

    public static void createToast(Context context, String str){
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }

}