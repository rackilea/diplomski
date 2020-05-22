public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int uppers = scan.nextInt();
    int lowers = scan.nextInt();
    int digits = scan.nextInt();
    int quantity = scan.nextInt();
    int freeChoices = quantity - uppers - lowers - digits;
    if (freeChoices < 0) {
        System.exit(1);
    }
    ThreadLocalRandom r = ThreadLocalRandom.current();
    StringBuilder password = new StringBuilder();
    boolean isPasswordReady = false;
    int lastUpper = -1, lastLower = -1, lastDigit = -1;
    PasswordPart[] options = PasswordPart.values();
    while (!isPasswordReady) {
        int partChoice = r.nextInt(0, options.length);
        switch (options[partChoice]) {
            case DIGIT:
                if (digits > 0 || freeChoices > 0) {
                    CharIndexHolder result = options[partChoice].get(lastDigit, -1, r);
                    password.append(result.c);
                    lastDigit = result.i;
                    if (digits == 0) {
                        freeChoices--;
                    } else {
                        digits--;
                    }
                }
                break;
            case LOWER:
                if (lowers > 0 || freeChoices > 0) {
                    CharIndexHolder result = options[partChoice].get(lastLower, lastUpper, r);
                    password.append(result.c);
                    lastLower = result.i;
                    if (lowers == 0) {
                        freeChoices--;
                    } else {
                        lowers--;
                    }
                }
                break;
            case UPPER:
                if (uppers > 0 || freeChoices > 0) {
                    CharIndexHolder result = options[partChoice].get(lastUpper, lastLower, r);
                    password.append(result.c);
                    lastUpper = result.i;
                    if (uppers == 0) {
                        freeChoices--;
                    } else {
                        uppers--;
                    }
                }
                break;

        }

        isPasswordReady = uppers == 0 && lowers == 0 && digits == 0 && freeChoices == 0;
    }

    System.out.println(password.toString());
}

enum PasswordPart {
    UPPER("QWERTYUIOPASDFGHJKLZXCVBNM"), LOWER("qwertyuiopasdfghjklzxcvbnm"), DIGIT("1234567890");
    private String pool;

    PasswordPart(String pool) {
        this.pool = pool;
    }

    public CharIndexHolder get(int lastIndex, int additionalIndex, ThreadLocalRandom random) {
        int i = random.nextInt(0, pool.length());
        while (i == lastIndex || i == additionalIndex) {
            i = random.nextInt(0, pool.length());
        }

        return new CharIndexHolder(pool.charAt(i), i);
    }
}

private static class CharIndexHolder {
    char c;
    int i;


    CharIndexHolder(char c, int i) {
        this.c = c;
        this.i = i;
    }
}