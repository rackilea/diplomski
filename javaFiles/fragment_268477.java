double totalMinTemp = 0.0;
int count = 0;
for(TempRead entry : t)
    if(entry.getMinTemp() != -9999)
    {
        avgMinTemp += entry.getMinTemp();
        count++;
    }
double avgMinTemp = totalMinTemp / count;