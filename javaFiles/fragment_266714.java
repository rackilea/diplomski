int[] f = new int[numberOfMatrices+1];
f[1] = 1;
f[2] = 1;

for(int i = 3; i<=numberOfMatrices; i++){
  for(int k=1; k < i; k++){ // k will be max. i-1
    f[i] += f[k]*f[i-k];
  }
}