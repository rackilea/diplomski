void writeWaveFileHeader(FileOutputStream out, long totalAudioLen, long totalDataLen, int sampleRate, int channels, long byteRate) throws IOException {
            byte[] header = new byte[44];
            header[0] = 'R'; // RIFF
            header[1] = 'I';
            header[2] = 'F';
            header[3] = 'F';
            header[4] = (byte)(totalDataLen & 0xff);
            header[5] = (byte)((totalDataLen >> 8) & 0xff);
            header[6] = (byte)((totalDataLen >> 16) & 0xff);
            header[7] = (byte)((totalDataLen >> 24) & 0xff);
            header[8] = 'W'; //WAVE
            header[9] = 'A';
            header[10] = 'V';
            header[11] = 'E';
            //FMT Chunk
            header[12] = 'f'; // 'fmt '
            header[13] = 'm';
            header[14] = 't';
            header[15] = ' ';
        
            header[16] = 16; // 4 bytes: size of 'fmt ' chunk
            header[17] = 0;
            header[18] = 0;
            header[19] = 0;
        
            header[20] = 1; // format = 1
            header[21] = 0;
        
            header[22] = (byte) channels;
            header[23] = 0;
        
            header[24] = (byte)(sampleRate & 0xff);
            header[25] = (byte)((sampleRate >> 8) & 0xff);
            header[26] = (byte)((sampleRate >> 16) & 0xff);
            header[27] = (byte)((sampleRate >> 24) & 0xff);
        
            header[28] = (byte)(byteRate & 0xff);
            header[29] = (byte)((byteRate >> 8) & 0xff);
            header[30] = (byte)((byteRate >> 16) & 0xff);
            header[31] = (byte)((byteRate >> 24) & 0xff);
        
            header[32] = (byte)(channels * 16 / 8);
            header[33] = 0;
        
            header[34] = 16;
            header[35] = 0;
            //Data chunk
            header[36] = 'd'; //data
            header[37] = 'a';
            header[38] = 't';
            header[39] = 'a';
            header[40] = (byte)(totalAudioLen & 0xff);
            header[41] = (byte)((totalAudioLen >> 8) & 0xff);
            header[42] = (byte)((totalAudioLen >> 16) & 0xff);
            header[43] = (byte)((totalAudioLen >> 24) & 0xff);
            out.write(header, 0, 44);
        }