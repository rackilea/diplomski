int x = Integer.parseInt(args[0]), help = 0, sum= 0;

if (x < 0) {
    x *= -1;
}

do {
    while(x != 0) {
        help = x % 10;
        sum += help;
        x /= 10;
    }

    System.out.println(sum);

    if(sum >= 10) {
        x = sum;
        sum = 0;
    }

}while(x >= 10);

if(sum / 9 == 1) {
    System.out.println("yes");
} else {
    System.out.println("no");
}