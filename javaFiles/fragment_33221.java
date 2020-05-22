while ((rdLen = gin.read(buf)) != -1) {
            if (rdLen<chunksize) {
                byte[] missBytes = new byte[chunksize-rdLen];
                int rdLine_miss = 0;
                if ((rdLine_miss = gin.read(missBytes)) > 0)
                    System.arraycopy(missBytes,0,buf,rdLen,rdLine_miss);
                rdLen += rdLine_miss;
            }
            for (int i=0; i<rdLen/4; i++) {
                byte[] bs = Arrays.copyOfRange(buf,(i*4),((i+1)*4));
                intCounter++;
                System.out.println(bs[0] + " " + bs[1] + " " + bs[2] + " " + bs[3] + " ");
            }
            chunkCounter++;
        }