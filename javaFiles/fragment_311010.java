public int getStart(int startFlag, int length) {
    for(int i=startFlag;i<length;i++)
            {
                if(c1[i]==c2[0])
                {
                    return i;
                }
            }
}