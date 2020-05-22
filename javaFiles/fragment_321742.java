int currentapiVersion = android.os.Build.VERSION.SDK_INT;
if (currentapiVersion >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1){
    // Do something for JellyBean and above versions
} else{
    // do something for phones running an SDK before JellyBean
}