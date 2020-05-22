String storage = "";
        int i = 0;
        while (i < 3) {
            int binny = this.giveMeBinary();
            storage += (String.valueOf(binny));
            i++;
        }

        int ans = Integer.parseInt(storage);