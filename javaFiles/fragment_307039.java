import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomReader cr = new CustomReader(1000000);
        int T = cr.nextInt(), fIndex, bIndex, fStartIndex, bStartIndex;
        StringBuilder output = new StringBuilder();
        byte[] input;
        boolean isAppend1 = false;
        for (int i = 0; i < T; i++) {
            input = cr.nextInput();
            fStartIndex = bStartIndex = cr.getCurrInputLength() / 2;
            isAppend1 = false;
            if (cr.getCurrInputLength() % 2 == 0) {
                bStartIndex--;
            }
            fIndex = fStartIndex;
            bIndex = bStartIndex;
            while (input[bIndex] == input[fIndex]) {
                if (bIndex - 1 < 0) {
                    break;
                } else {
                    bIndex--;
                    fIndex++;
                }
            }
            if (input[bIndex] > input[fIndex]) {
                while (bIndex >= 0) {
                    input[fIndex++] = input[bIndex--];
                }
            } else {
                if (input[bStartIndex] < 57) {
                    input[bStartIndex] = (byte) (input[bStartIndex] + 1);
                } else {
                    bIndex = bStartIndex;
                    while (bIndex >= 0 && input[bIndex] == 57) {
                        input[bIndex] = 48;
                        bIndex--;
                    }
                    if (bIndex >= 0) {
                        input[bIndex] = (byte) (input[bIndex] + 1);
                    } else {
                        input[0] = 49;
                        if (fStartIndex != bStartIndex) {
                            input[fStartIndex] = 48;
                            bStartIndex = fStartIndex;
                        } else {
                            input[fStartIndex + 1] = 48;
                            bStartIndex = fStartIndex = fStartIndex + 1;
                        }
                        isAppend1 = true;
                    }
                }
                while (bStartIndex > -1) {
                    input[fStartIndex++] = input[bStartIndex--];
                }
            }
            for (int j = 0; j < cr.getCurrInputLength(); j++) {
                output.append((char) input[j]);
            }
            if (isAppend1) {
                output.append("1");
            }
            output.append("\n");
        }
        System.out.print(output.toString());
        // genInput();
    }

    private static class CustomReader {
        private byte[] buffer;
        private byte[] currInput = new byte[1000000];
        private int currInputLength;
        private int currIndex;
        private int validBytesInBuffer;

        CustomReader(int buffSize) {
            buffer = new byte[buffSize];
        }

        public int nextInt() throws IOException {
            int value;
            byte b;
            while (true) {
                b = getNextByte();
                if (b > 47 && b < 58) {
                    break;
                }
            }
            value = b - 48;
            while (true) {
                b = getNextByte();
                if (b > 47 && b < 58) {
                    value = (value * 10) + (b - 48);
                } else {
                    break;
                }
            }
            return value;
        }

        public byte[] nextInput() throws IOException {
            byte b;
            this.currInputLength = 0;
            while (true) {
                b = getNextByte();
                if (b > 47 && b < 58) {
                    break;
                }
            }
            currInput[currInputLength++] = b;
            while (true) {
                b = getNextByte();
                if (b > 47 && b < 58) {
                    currInput[currInputLength++] = b;
                } else {
                    break;
                }
            }
            return this.currInput;
        }

        public int getCurrInputLength() {
            return this.currInputLength;
        }

        private byte getNextByte() throws IOException {
            if (currIndex == buffer.length || currIndex == validBytesInBuffer) {
                validBytesInBuffer = System.in.read(buffer);
                currIndex = 0;
            }
            return buffer[currIndex++];
        }
    }

    public static void genInput() {
        for (int i = 0; i < 100; i++) {
            System.out.println((int) (Math.random() * 1000000000));
        }
    }
}