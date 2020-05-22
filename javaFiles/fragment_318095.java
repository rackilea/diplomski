int biggest[] = new int[big];
int smallest[] = new int[small];

int currentBiggest = 0;
int currentSmallest = 0;

for(int j = 0; j < nummer.length; j++){
    if(nummer[j] <= 500){
        smallest[currentSmallest++] = nummer[j];
    }
    else {
        biggest[currentBiggest++] = nummer[j];
    }
}