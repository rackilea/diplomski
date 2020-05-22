String folder = "/";
AssetManager am = getResources().getAssets();
String fileList[] = am.list(folder);
for(int i = 0; i < fileList.length; i++)
{
    Log.e("Test", fileList[i]);
}