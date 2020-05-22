public class RecibeNotif extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String[] frasesaux;
        int iteraux;
        SharedPreferences settings = context.getSharedPreferences("MyPrefsFile",0);
        iteraux = settings.getInt("iterador",0);
        //                                   ^^ your default value

        //iteraux=MainActivity.iterador;
        frasesaux=context.getResources().getStringArray(R.array.cartas);
        // ^^ fetch the array 
        if(iteraux==frasesaux.length){
            iteraux=0;
        }
        //...
   }
}