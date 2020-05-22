byte[] headerdata = new byte[12];
                input.read(headerdata, 0, 2);
                int frame = (headerdata[0] & 0b10000000) & 0xFF;
                long length = (headerdata[1] & 0b01111111) & 0xFF;
                System.out.format("Before: %d, Frame: %d%n", length, frame);
                if(length == 127){
                    input.read(headerdata, 0, 12);
                    length = ((long)(headerdata[0] << 56) & 0xFFFFFFFFFFFFFFFFL | (long)(headerdata[1] << 48) & 0xFFFFFFFFFFFFFFL | (long)(headerdata[2] << 40) & 0xFFFFFFFFFFFFL | (long)(headerdata[3] << 32) & 0xFFFFFFFFFFL | (headerdata[4] << 24) & 0xFFFFFFFFL | (headerdata[5] << 16) & 0xFFFFFFL | (headerdata[6] << 8) & 0xFFFFL | headerdata[7] & 0xFFL);
                }else if(length == 126){
                    input.read(headerdata, 6, 6);
                    length = ((headerdata[6] << 8) & 0xFFFF | headerdata[7] & 0xFF);
                }else{
                    input.read(headerdata, 8, 4);
                }
                System.out.println("After: " + length);

                int count;
                int total = 0;
                byte[] buffer = new byte[16384];
                boolean done = false;
                while(done == false){
                    if(length - total > buffer.length) count = input.read(buffer, 0, buffer.length);
                    else count = input.read(buffer, 0, (int) (length - total));
                    //System.out.println(count);
                    for(int i = 0; i < count; i++){
                        buffer[i] = (byte)(buffer[i] ^ headerdata[(total & 3) + 8]);
                        total++;
                    }
                    fileoutput.write(buffer, 0, count);
                    //System.out.format("Count: %d Left: %d%n", count, (length - total));
                    if(total >= length){
                        done = true;
                    }
                }

                if(frame == 128) break;