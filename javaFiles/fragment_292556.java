StringBuilder storage = new StringBuilder();
        int i = 0;
        while (i < 3) {
            int binny = this.giveMeBinary();
            storage.append(String.valueOf(binny));
            i++;
        }

        int ans = Integer.parseInt(storage.toString());