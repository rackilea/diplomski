public void step() {
        k = (int)Math.ceil(((-1 + Math.sqrt(1 + 8 * n)) / 2));
        int Sk = (1 + k) * k / 2;
        if ((Sk - n) % 2 != 0) {
            k++;
            Sk = (1 + k) * k / 2;
            if ((Sk - n) % 2 != 0) {
                k++;
                Sk = (1 + k) * k / 2;
            }
        }
        int i = (Sk - n) / 2;
        System.out.println("maximum number is : " + k + "the number with -ve sign is : " + i);
    }