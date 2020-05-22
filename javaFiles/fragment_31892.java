public void extractFile(String fileName){
        try{
            BufferedReader bf = new BufferedReader(new FileReader(fileName));
            try {
                String readBuff = bf.readLine();

                while (readBuff!=null){

                    Pattern checkData = Pattern.compile("^(19|20)\\d\\d([-/.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])\\b.+$");
                    Matcher match = checkData.matcher(readBuff);

                    if (!match.find()){
                        readBuff = null;
                    }

                    else if (match.find()){

                        String[] splitReadBuffByComma = new String[3];
                        splitReadBuffByComma = readBuff.split(",");

                            for (int x=0; x<splitReadBuffByComma.length; x++){

                                if (x==0){
                                    dHourList.add(splitReadBuffByComma[x]);
                                }
                                else if (x==1){
                                    throughputList.add(splitReadBuffByComma[x]);
                                }
                                else if (x==2){
                                    avgRespTimeList.add(splitReadBuffByComma[x]);
                                }
                            }
                    }

                    readBuff = bf.readLine();
                }
            }
            finally{
                bf.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found dude: "+ e);
        }
        catch(IOException e){
            System.out.println("Error Exception dude: "+e);
        }
    }