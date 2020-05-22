String[] finalmsgs3 = finalmsgs2[3].split("RR");     // switch first two lines
String[] msgoptions = new String[finalmsgs3.length]; // initilize the other array
for(i = 0; i < finalmsgs3.length; i++)               // Array index starts at 0
{
    msgoptions[i] = finalmsgs3[i];
    Log.e(TAG, "---------------" + msgoptions[i]);
}