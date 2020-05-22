int fLength = files.size();
File[] fileArray = files.toArray(new File[fLength]);
for(int f=0; f<files.size(); f++)
{
//log file Reader init:
    String corrFile = fileArray[f].toString();
    BufferedReader corrReader = new BufferedReader(new InputStreamReader(new FileInputStream(corrFile),"UTF-16LE"));
        //NOTE: PFO differential correction log files are encoded in UTF-16 LE