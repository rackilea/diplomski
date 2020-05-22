public static String byte2hex(byte[] binput) {

        StringBuilder sb = new StringBuilder(binput.length * 2);
        for (int i = 0; i < binput.length; i++) {
            int high = ((binput[i] & 0xF0) >> 4);
            int low = (binput[i] & 0x0F);
            sb.append(hexchars[high]);
            sb.append(hexchars[low]);
        }
//sb : 56E048B73E9B3EFF42C509B772AF6941FF0B5BA5
        return sb.toString();
    }