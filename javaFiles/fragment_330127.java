for(int i = 0; i <= (n/2); i++) {
    for (int j = 0; j <= n; j++) {
        if (i == 0 || i == n) {
            System.out.print(c);
        }
        else if (j == 0 || j == n) {
            System.out.print(c);
        }
        else if (j == n/2 && i == ((n/2)/2)+1) {
            System.out.print(message);
            j = j + message.length() - 1;
        }
        else {
           System.out.print(" ");
        }
    }
    System.out.println();
}
for(int i = 0; i <= n; i++){
    System.out.print(c);
}