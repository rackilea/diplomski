Scanner scanner = new Scanner(System.in);
int sum = 0;               

while (true) {
    int read = scanner.nextInt();
    if (read == -1) {
        sum += read; //have to include -1 to sum
        break;
    }

    //read = scanner.nextInt(); you have to delete this line

    sum += read;
}

System.out.println(sum);
}