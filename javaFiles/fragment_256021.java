ArrayList<String> listSoundNames;
listSoundNames=new ArrayList<String>();
// store file name in listSoundNames
int pos = s.lastIndexOf(".");
if (pos > 0) {
    fileName = s.substring(0, pos);
}
listSoundNames.add(fileName);