private static byte[] stateToBytes(int[] state) {
        byte[][] temp = new byte[state.length][];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = intToBytes(state[i]);
        }

        return merge(temp);
    }

    private static int[] stateToInt(byte[] state) {
        int[] out = new int[state.length / 4];
        for (int i = 0; i < (state.length / 4); i++) {
            out[i] = byteArrayToInt(Arrays.copyOfRange(state, (i * 4), ((i + 1) * 4)));
        }

        return out;
    }