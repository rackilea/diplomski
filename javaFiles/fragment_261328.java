List<String> templist = new ArrayList<String>() ;
List<String> ds = new ArrayList<String>() ;

String s = "aaa";

String selecfin = null ;
String tmp = null;

for(int i=0; i<templist.size(); i++) {
  if(tmp != null) {
    tmp = tmp + "," + templist.get(i);
  } else {
    tmp = templist.get(i);
  }
}

selecfin = s + ".(" + tmp + ")";

ds.add(selecfin);