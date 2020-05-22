System.out.print("\nEnter the linear Address (32bit) :\t");
    Scanner sc = new Scanner(System.in);
    String linear_hex= sc.nextLine();
    String linear_bin= Integer.toBinaryString(Integer.parseInt(linear_hex,16));

    if(linear_bin.length() != 32) {         
        // Should be i < 32 instead of i <= 32, else you end up with an extra 0
        // Also consider using StringBuilder instead of String concatenation here
        for(int i= linear_bin.length(); i < 32; i++)
            linear_bin= 0+linear_bin;
    }
    System.out.println(linear_bin);