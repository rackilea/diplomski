for (int i = 0; i < max; i++) {
                    if (!isPrime[i]) {
                        for (int j = 2*i; j < max; j += i) {
                            isPrime[j] = true;
                        }
                    } else {}  // By the way - This is really not necessary
                }