Scanner input = new Scanner(System.in);
          ArrayList<Integer> al = new ArrayList<Integer>();

            int check=0;
            while(true){
                check = input.nextInt();
                if(check == 0) break;
                al.add(check);

            }

            for (int i : al) {
                System.out.print(i);
            }


}