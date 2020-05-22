public Object blankPosition(int blankNum) {
            int blank = 0;
            int i = 0;
            while (i < sentence.length()) {
                if (sentence.charAt(i) == ' ') {
                    blank++;
                    if (blank == blankNum)
                        return i;
                }
                i++;
            }
            return i;
        }