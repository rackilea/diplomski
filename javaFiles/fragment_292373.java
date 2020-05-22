int c = 1;
    StringBuffer sb = new StringBuffer();
    for (int x = 1; x < 32; x++) {
        sb.append(x + ",");
        c++;
        if (c == 6) {
            System.out.println("ADDED TO COLLECTION: " + sb.toString());
            sb = new StringBuffer();
            c = 0;
        }
    }
    // after the last iteration there is still something left in sb:
    System.out.println("ADDED TO COLLECTION: " + sb.toString());