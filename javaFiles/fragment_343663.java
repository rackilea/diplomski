for (int j = lb; j <= ub; j++) {
        sd = 0;
        sosd = 0;
        pf = 0;
        pff = 0;
        temp = j;
        do {
            sd = sd + (temp % 10);
            sosd = sosd + ((temp % 10) * (temp % 10));
            temp = temp / 10;
        } while (temp != 0);
        // Check for 1
        if (sd == 1 || sosd == 1) continue;
        for (int p = 2; p <= (sd / 2); p++) {
            if (p == sd / 2) {
                pf = 0;
            }
            if (sd % p == 0) {
                pf = 1;
                break;
            }
        }
        for (int p = 2; p <= (sosd / 2); p++) {
            if (p == sosd / 2) {
                pff = 0;
            }
            if (sosd % p == 0) {
                pff = 1;
                break;
            }
        }
        if (pf == 0 && pff == 0) {
            count++;
        }
    }
    System.out.println(count);