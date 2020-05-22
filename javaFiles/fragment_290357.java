int[] A = new int[]{1,2,3,7,8,9};
int[] B = new int[]{4,5,6,10,11,12};
int[] C = new int[12];

int aIndex= 0;
int bIndex= 0;
for(int i=0; i<C.length; i++) {
    if((i >= 0 && i < 3) || (i >= 6 && i < 9))
        C[i] = A[aIndex++];
    else
        C[i] = B[bIndex++];
}