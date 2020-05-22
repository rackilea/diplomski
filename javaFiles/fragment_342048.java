int startIndex= 10;
int maxResultCountCount = 115;
int endIndex = 0;
int spacing=10;
int maxValue=maxResultCountCount+startIndex;
int endIndex =endIndex+spacing;
while(startIndex < maxValue){
        System.out.println(startIndex+"              "+endIndex);
        startIndex = endIndex + 1;
        endIndex =  endIndex+spacing;
        if(endIndex>maxValue)
            endIndex=maxValue;
}