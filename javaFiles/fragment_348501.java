Devices d = Devices.getInstance();
String s = d.getString();
String[][] all = getDevices(s);

deviceName = all[0];
ip = all[1];
String[] pre_imgid = all[2];
int x = pre_imgid.length;
Integer[] imgid = new Integer[x];
for (int i = 0; i < x; i++){
    switch(pre_imgid[i]){
        case "0":
            imgid[i] = R.drawable.large_circle_szary; break;
        case "1":
            imgid[i] = R.drawable.large_circle_czerwony; break;
        case "2":
            imgid[i] = R.drawable.large_circle_pomarancz; break;
        case "3":
            imgid[i] = R.drawable.large_circle_zielony; break;
        default:
            imgid[i] = R.drawable.large_circle_niebieski; break;
    }
}