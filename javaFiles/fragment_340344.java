char a[] = "GUM".toCharArray();
        char b[] = "MUG".toCharArray();
        char temp;
        int n = b.length;
        int j, i = 0;

        System.out.println(a);
        while (n > i) {
            j = i;
            while (a[j] != b[i]) {
                j++;
            }
            while (j > i) {
                temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
                System.out.println(a);
                j--;
            }
            i++;
        }