double ini = 1;
for (int m = 1; m < arraydc.length; m++)
{
    arrdec[m][1] = arrtemp[m][1]; 
    if (m != 1 && arrtemp[m][0] == arrtemp[m - 1][0])
    {
        ini++;           
    }
    arrdec[m][0] = ini;
    System.out.println(arrdec[m][0] + "\t\t");
}