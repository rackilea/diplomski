String[2] A = {"A1","A2"};
String[3] B = {"B1","B2","B3"};
String[2] C = {"C1","C2"};
String[3] D = {"D1","D2","D3"};
for(int i = 0; i < A.length;i++){
   for(int j = 0;j < B.length;j++){
     for(int t = 0; t < C.length;t++){
        for(int e = 0; e < D.length;e++){
            System.out.printfln(A[i] + " " + B[j] + " " + C[t] + " " + D[e]);
        }
     }
   }
}