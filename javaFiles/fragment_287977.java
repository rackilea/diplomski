public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = Integer.parseInt(input.nextLine());
        int total;
        for(int i = 0; i < k; i++){
           total = 0; 
           String line = input.nextLine();
           Scanner lineToken = new Scanner(line);
            while(lineToken.hasNextInt()){   
                  total = total + lineToken.nextInt();                     
            }
            System.out.println(total);
        }           
  }