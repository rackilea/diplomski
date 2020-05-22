static public void main(String[] args) {
        int a[] = new int[6];
        a[0] = 2; a[1] = 2; a[2] = 3;
        int b[] = new int[3];
        b[0] = 1; b[1] = 7; b[2] = 8;
        sort (a, b, 2, 2);
        for (int i = 0; i < 6; i++)
            System.out.println (a[i]);
    }
}