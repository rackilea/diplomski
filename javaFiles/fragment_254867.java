while (true) {
        in.mark(128);
        if ((inputLine = in.readLine()) == null)
            continue;

        System.out.println("Response: " + inputLine);

        in.reset();
        i = 0;
        while (in.ready()) {
            c = in.read();
            System.out.printf("%2d: 0x%02X o%03o %3d %c%n",
                i++,
                c, c, c,
                Character.isISOControl((char) c) ? '.' : (char)c
            );
        }
    }