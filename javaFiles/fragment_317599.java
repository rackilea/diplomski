int [] x = new int[10];

for(int i = 0; i < x.length; i++){
    x[i] = kb.nextInt();
}

int max = x[0];
int maxIndex = 0;
for(int i = 1; i < x.length; i++){
    if(x[i] > max){
        max = x[i];
        // This is where you update the index
        maxIndex = i
    }
}