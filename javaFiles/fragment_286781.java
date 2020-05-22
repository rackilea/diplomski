public static void main(String[] args) {

        printMatrix(5);


    }
    public static void printMatrix (int n) {

        int d = n +(n-1);
        int k = n*2;
        int g = -1;

        for (int i = 0; i < d ; i++)
        {
            if(i<n){
                g++;
            }
            else{k=n*2;
                g--;}

            for(int j = 1; j <=d; j++){
                if (i < n){
                int abs = Math.abs(j-n);
                System.out.print(abs>i ? "*" : i-abs+1);
                }
                else{
                    k--;
                    int abs = Math.abs(k-n);
                    System.out.print(abs>g ? "*" : g-abs+1);

                }

            }
            System.out.println("");
        }

    }
}