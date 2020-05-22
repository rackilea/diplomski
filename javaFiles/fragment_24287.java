// int num = cin.nextInt();
int num;
do{
    num = cin.nextInt();
    System.out.println("num is " + num);
    if (num > 0 && num <= str.size()) {
      System.out.println(str.get(num - 1));
    }
} while(num != 0);