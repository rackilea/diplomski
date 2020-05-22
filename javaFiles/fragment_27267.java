private int substrCount(string findStr, string str)
{
    lastIndex = 0;
    count = 0;
    while(lastIndex != -1){
        lastIndex = str.indexOf(findStr, lastIndex);

        if(lastIndex != -1){
            count++;
        }
    }
}