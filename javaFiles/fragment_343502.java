String output="",line1,line2;
for(int i=0;i<lstFile.size();i++)
{

    line1=lstFile.get(i);
    if(line1.contains("in") && line1.contains("out"))continue;
    for(int j=i+1;j<lstFile.size();j++)
    {
        line2=lstFile.get(j);

        if(line2.contains("in") && line2.contains("out"))continue;

        if(line1.contains(getNameDate(line2)) && line2.contains("out") && line1.contains("in"))
        {
              output+=line1+line2.substring(line2.lastIndexOf(","),line2.length());
              output+=System.getProperty("line.separator");
              break;
        }
    }
}
//output now contains your desired result