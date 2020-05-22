//costs
int[] A = {4, 1, 1};
int[] B = {3, 2, 1};
dint[] C = {1, 3, 2};

public int minPhone(int r, int g, int b){
    int minA = 0;
    int minB = 0;
    int minC = 0;
    if(r-A[0] > 0,g-A[1] > 0,r-A[2] > 0){ //can I make a case A?
        minA = minPhone(r-A[0],g-A[1],r-A[2]);
    }
    if(r-B[0] > 0,g-B[1] > 0,r-B[2] > 0){ //can I make a case B?
        minB = minPhone(r-B[0],g-B[1],r-B[2]);
    }
    if(r-C[0] > 0,g-C[1] > 0,r-C[2] > 0){ //can I make a case C?
        minC = minPhone(r-C[0],g-C[1],r-C[2]);
    }
    minABC = min(minA,min(minB,minC));
    return minABC;
}