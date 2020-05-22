public class Unique-Numbers {
    public static void main(String[] args) {
        int a[] = {2,5,3,6,5,1};
        System.out.println(getUniqueNumbers(a));
    }
    public static String getUniqueNumbers(int a[])
    {
        String result="";
        for(int i=0;i<a.length;i++)
        {
            int count=0;
            for(int j=0;j<a.length;j++)
                if(a[i]==a[j])
                    count++;
            if(count==1)
                result += a[i]+ " ";
        }
if(result=="")        
return null;
if(a.Length==0)
return -1;
        return result;

    }

}