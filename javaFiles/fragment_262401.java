if(encoding == AudioFormat.ENCODING_PCM_8BIT){  
            ShortBuffer intBuf = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer();
            short[] samples16Bit = new short[intBuf.remaining()];
            intBuf.get(samples16Bit);
            data1 = new byte[samples16Bit.length];
            for (int i = 0; i < samples16Bit.length; i++) {
                data1[i] = (byte)((samples16Bit[i] / 256)+128);
            }
        }