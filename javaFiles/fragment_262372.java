int[] p = {1,2,3,4,5};
int oddCount=0;
int evenCount=0;

    System.out.print("Even numbers: ");
    for (int i = 0; i < p.length; i++) {

        if (p[i] == 0) {
        } else if (p[i] % 2 == 0) {
            System.out.print(p[i] + " ");
            evenCount++;
        }

    }

    System.out.println("Evencount"+evenCount);

    System.out.print("\nOdd numbers: ");
    for (int i = 0; i < p.length; i++) {
        if (p[i] % 2 != 0) {
            System.out.print(p[i] + " ");
            oddCount++;
        }
    }

    System.out.println("Odd count"+oddCount);