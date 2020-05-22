Map<String,int[]> myMap = new HashMap();

int []x = {1,2,3,4};
int []y = {5,6,7,8};
int []z = {9,2,3,4};

myMap.put("X",x);
myMap.put("Y",y);
myMap.put("Z", z);

int i = 0;
int [][]matrix = new int[10][10];

for(Entry<String, int[]> entry : myMap.entrySet()){

    int []a =entry.getValue();

    for(int j = 0; j < a.length; j++){

        matrix[i][j] = a[j];
    }
    i++;
}