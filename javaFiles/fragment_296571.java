int maxcol = 0;
for(int i = 0; i < test.length; i++)
    if(test[i].length > maxcol)
        maxcol = test[i].length;


int[] result = new int[maxcol];

for (int j = 0; j < maxcol; j++)
    for (int i = 0; i < test.length; i++)
        if (test[i].length > j && result[j] < test[i][j])
            result[j] = test[i][j];