int length = s1.length;
for(i=0;i<length;i++)
{
    if(s1[i].equals(s2[i]))
        c++;    
}
if(c==7)
    System.out.println("right way");    
else
    System.out.println("wrong way");