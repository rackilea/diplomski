public static void main(String[] args)throws IOException {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int arr[][] = new int[n][m];
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            arr[i][j] = sc.nextInt();
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            System.out.println(arr[i][j]);  //MODIFICATION
        }
        System.out.println("\n");
    }
    sc.close();
}