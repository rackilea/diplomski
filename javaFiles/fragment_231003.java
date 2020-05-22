int[] compOld = new int[3];
String[] split = versionOld.split(".");
for (int i = 0; i < split.length; i++)
    compOld = Integer.parseInt(split[i]);
int[] compNew = new int[3]
...
return compOld[0] < compNew[0] || compOld[1] < compNew[1] || compOld[2] < compNew[2];