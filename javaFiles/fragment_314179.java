Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    int max = 0, count = 0, value = 0;

    while (num > 0){

        value = num % 10;
        num = num / 10;
        if (value > max){
            max = value;
            count = 1;
        } else if (value == max){
            count++;
        }
    }

    System.out.println(max); // 6 for 2556621 
    System.out.println("count is " + count); // 2 for 2556621
}