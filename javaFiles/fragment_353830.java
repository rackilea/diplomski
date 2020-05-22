protected void onDestroy ()
{
    mQCARShared.onDestroy();
    mUnityPlayer.quit();
    super.onDestroy();
}