private final Object lock = new Object();

    private String getNextString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        synchronized (lock) {
            sb.append(index);
            if (map.containsKey(sb.toString()))
                System.out.println("dublicate:" + sb.toString());
        }
        return sb.toString();
    }

    private int getNextInt() {
        synchronized (lock) {
            return index++;
        }
    }