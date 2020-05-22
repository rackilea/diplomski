class PacketInputStream extends DataInputStream {

        private static final Charset UTF8 = Charset.forName("UTF-8");

        public PacketInputStream(InputStream myis) {
            super(myis);
        }

        public String readString() throws IOException {
            int length = readVarInt();
            byte[] data = new byte[length];
            readFully(data);
            return new String(data, UTF8);
        }

        public int readVarInt() throws IOException {
            int i = 0;
            int j = 0;
            while (true) {
                byte k = readByte();
                if (k == -1)
                    throw new IOException("End of stream");

                i |= (k & 0xFF) << j++ * 7;

                if (j > 5)
                    throw new IOException("VarInt too big");

                if ((k & 0x80) == 128)
                    break;
            }

            return i;
        }

        public long readVarLong() throws IOException {
            long varInt = 0;
            for (int i = 0; i < 10; i++) {
                byte b = readByte();
                varInt |= ((long) (b & (i != 9 ? 0x7F : 0x01))) << (i * 7);

                if (i == 9 && (((b & 0x80) == 0x80) || ((b & 0x7E) != 0)))
                    throw new IOException("VarInt too big");
                if ((b & 0x80) == 0x80)
                    break;
            }

            return varInt;
        }

        public byte[] readBytes() throws IOException {
            return readBytes(readShort());
        }

        public byte[] readBytes(int length) throws IOException {
            if (length < 0)
                throw new IOException("Invalid array length");
            byte[] data = new byte[length];
            readFully(data);
            return data;
        }

    }