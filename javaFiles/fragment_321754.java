public byte[] hexToString(String hex) {
        // hexToString that works at a byte level, not at character level
        byte[] output = new byte[(hex.length() + 1) / 2];
        for (int i = hex.length() - 1; i >= 0; i -= 2) {
            int from = i - 1;
            if (from < 0) {
                from = 0;
            }
            String str = hex.substring(from, i + 1);
            output[i/2] = (byte)Integer.parseInt(str, 16);
        }
        return output;
    }