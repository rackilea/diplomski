String[][] trim=new String[sentenceList.size()][largest];
StringTokenizer st1;
boolean isStop;
for(int i=0;i<sentenceList.size();i++)
{
    st1= new StringTokenizer(sentenceList.get(i)," ,(){}[]/.;:'&?!");
    int count=st1.countTokens();
    for(int j=0;j<count;j++)
    {
        isStop = false;
        String token=st1.nextToken();
        for(int k=0;k<stopwords.length;k++)
        {
            if(token.equals(stopwords[k])) {
                isStop = true;
                break;
            }
        }
        if(isStop)
            continue;
        else {
            trim[i][j]=token;
        }                   
    }
 }
//PRINT CHECK
for(int i=0;i<sentenceList.size();i++)
{
    for(int j=0;j<largest;j++)
    {
        if(trim[i][j]!=null)
        System.out.print(trim[i][j]+" ");
    }
    System.out.println();
}