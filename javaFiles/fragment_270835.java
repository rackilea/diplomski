private String GetFirstSplitN(String str,int n,String splitUsing)
{
    StringBuilder sb=new StringBuilder();
    String []temp=str.split(splitUsing);

    for(int i=0;i<n;i++)
    {
        if(sb.length>0)sb.append(splitUsing);
        sb.append(temp[i]);
    }

    return sb.toString();      
}