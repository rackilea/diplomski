byte k = stream[i];

        int b = 0;
        try {
            String hexStringNumber = String.format("0x%02X",k);
            b = Integer.decode(hexStringNumber);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }