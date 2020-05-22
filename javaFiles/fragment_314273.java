for (int i = 2; i <= 100; i++) {
            isComposite = false;
            if ((i % 2) == 0) {
                continue;
            }

            for (int k = 3; k < i; k++) {
                if ((i % k) == 0) {
                    isComposite = true;
                    break;
                }
            }

            if (!isComposite) {
                System.out.println(i);
                isComposite = false;
            }
        }