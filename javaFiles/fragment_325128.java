int[] num={5,2,10,12,4};
String[] name={"a","b","g","c","r"};
int tempNum;
String tempName;

for (int i = 0; i < num.length; i++) 
        {
            for (int j = i + 1; j < num.length; j++) 
            {
                if (num[i] > num[j]) 
                {
                    tempNum = num[i];
                    tempName=name[i];

                    num[i] = num[j];
                    name[i] = name[j];

                    num[j] = tempNum;
                    name[j] = tempName;
                }
            }
        }