String[] splited = tweetToAnal.split("\\s+");
for (String elem : splited) {

String newElem = "";
if (elem.startsWith("@")) {
    newElem = elem.substring(1).toLowerCase().split("[a-z0-9-_]+")[0];
}

if (newElem.length() > 0) mentioned.add(newElem);