int size = 5;
int[] values = new int[100];
int[] list = new int[size];
for( int i = 0; i < 100; i++ ) values[i] = i;
Random rand = new Random();
int ctListSize = 0;
int xList = 0;
while( true ){
    int iCandidateValue = rand.nextInt(100);
    if( values[ iCandidateValue ] == 0 ) continue; // already used
    list[ xList++ ] = iCandidateValue;
    values[ iCandidateValue ] = 0;
    if( xList == size || xList == 100 ) break;
}

for(int element : list) System.out.print(element + " ");