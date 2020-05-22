for(int i = 0; i < 5-1; i ++)
{
    for(int j = i +1; j < 5; j++)
{
 if (ArrMarks[i] < ArrMarks[j]) 

 {
    //sorting the names
    String temp = ArrNames[i];
    ArrNames[i] = ArrNames[j];
    ArrNames[j] = temp;

    //sorting the marks
    int temp1 = ArrMarks[i];
    ArrMarks[i] = ArrMarks[j];
    ArrMarks[j] = temp1;  

}  

}   
txaDisplay.append("Names:"+"\t\t"+"Marks"+"\n");

        txaDisplay.append(ArrNames[i]+"\t\t"+ArrMarks[i]+"\n"); 
}