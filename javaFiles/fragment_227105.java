List<Pending> pending = db.getAllPending();
List<String> resultingStrings = new ArrayList<String>();
String a = "";
for (Pending pn : pending) {
  if (a.length() + pn.getPm_str().length() < 160) { // < to leave room for the comma as well
        if(a.length() != 0) { // don't add a comma before the first 1
          a+=",";
        }
        a+=pn.getPm_str();
  } else {
        resultingStrings.add(a);
        a = pn.getPm_str();
  }
}
resultingStrings.add(a);