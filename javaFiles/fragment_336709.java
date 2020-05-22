public static void main(String[] args) {
    Scanner scan=new Scanner(System.in);
    int n=Integer.parseInt(scan.nextLine());
    String[][] multi = new String[n][n];
    int i=0;
    int t=0;
    while(t<n){
        String s=scan.nextLine();
        String b[]=s.split("\\,");
        for(int j=0;j<b.length;j++){
            multi[i][j]=b[j];
        }
            i++;
            t++;
        }

    System.out.println(multi[0][0]);

    for(int k=0;k<n;k++){
        for(int j=0;j<n;j++){
            System.out.print(multi[k][j]+"  ");
        }
        System.out.println();
    }

    }