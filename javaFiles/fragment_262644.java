int v = 0;
            if (c >= '0' && c <= '9') {
                v = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                v = 10 + (c - 'A');
            }
            if (v > max) {
                max = v;
            }