String str1 = "";
ArrayList<String> all =  new ArrayList<String>();
for (String bean : myAdapter.myId) {
    String s = getFacebook(ConnectedActivity.this, Integer.parseInt(bean));
    all.add(s);
}

int i,j;
for (i=0;i<all.size();i++)
{
    String temp = all.get(i);
    boolean found = false;
    for (j=i+1;j<all.size();j++)
    {
        if(temp.equals(all.get(j)))
        {
            found = true;
            all.remove(j);
            j--;
        }
    }
    if (!found)
        str1 += "," + temp;
}
System.out.println(str1);