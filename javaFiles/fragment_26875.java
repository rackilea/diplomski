String[] strSplit = myStr.split(" ");
SensorInfo info = new SensorInfo();
info.ret = afterEquals(strSplit[0]);
info.htemp = Double.parse(afterEquals(strsplit[1]));
info.hhum = afterEquals(strSplit[2]);
info.otemp= Double.parse(afterEquals(strSplit[3]));
info.err = Integer.parse(afterEquals(strSplit[4]));
info.cmpfreq = Integer.parse(afterEquals(strSplit[5]));