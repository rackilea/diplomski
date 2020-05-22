public static void main(String[] args) {

    int w[][] = {
     {1,2,3,4,5},
     {6,7,8,9,10},
     {11,12,13,14,15}
    ,{16,17,18,19,20}
    ,{21,22,23,24,25}};

    for(int i = 0 ;i< w.length ; i++){
        System.out.println("\n");
        for(int j=0; j< w.length ;j++)
            if(i!=0&&i== j){

                for(int k=0;k<j;k++){
                    System.out.print(w[i][k]+"\t"); 

                }
            }
    }
}