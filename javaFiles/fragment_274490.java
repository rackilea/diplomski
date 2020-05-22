public class PublicParFun {

    public static void setAdIfNotRegistered(AdView adView){
        if(adView.getContext().getResources().getBoolean(R.bool.IsRegistered) == false)
            SetAD(adView);
    }    

    public static void SetAD(AdView adView){  
        AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();
        adView.loadAd(adRequest);
    }

}