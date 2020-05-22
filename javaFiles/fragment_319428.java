StringBuilder blockStringBuilder = new StringBuilder();
for (int i=-300;i<300;i++){
                //whole world Generation(taking up nearly no time)
                int f=0;
                int max=50;
                while (f<max){
                    if (blockCount[blockCount.length/2+i][0][0]==32&&blockCount[blockCount.length/2+i][0][1]==0){
                        max=f;
                    }
                    if (!(blockCount[blockCount.length/2+i][f][0]==32&&blockCount[blockCount.length/2+i][f][1]==0)){
                        int t=codeTexture(blockCount[blockCount.length/2+i][f][0],blockCount[blockCount.length/2+i][f][1]);
                        blockStringBuilder.append("[").append(blockCount.length/2+i).append("][").append(f).append("]").append(t);

                    }
                    if ((blockCount[blockCount.length/2+i][f][0]==48&&blockCount[blockCount.length/2+i][f][1]==64)||(blockCount[blockCount.length/2+i][f][0]==32&&blockCount[blockCount.length/2+i][f][1]==64)||(blockCount[blockCount.length/2+i][f][0]==0&&blockCount[blockCount.length/2+i][f][1]==64)||(blockCount[blockCount.length/2+i][f][0]==0&&blockCount[blockCount.length/2+i][f][1]==0)||(blockCount[blockCount.length/2+i][f][0]==16&&blockCount[blockCount.length/2+i][f][1]==16)){
                        max=f+10;
                    }
                    f=f+1;
                }
             }
             blockString = blockStringBuilder.toString();