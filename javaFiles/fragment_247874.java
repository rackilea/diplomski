while(str != null){
            //System.out.println("IN");
            MyObject myObject = new MyObject();

            String [] tkn = str.split(",");

            myObject.setDelta(Long.parseLong(tkn[0]));
            myObject.setTheta(Long.parseLong(tkn[1]));
            myObject.setSignal_1(Long.parseLong(tkn[2]));
            myObject.setSignal_2(Long.parseLong(tkn[3]));
            myObject.setSignal_3(Long.parseLong(tkn[4]));
            myObject.setSignal_4(Long.parseLong(tkn[5]));
            myObject.setSignal_5(Long.parseLong(tkn[6]));
            myObject.setSignal_6(Long.parseLong(tkn[7]));
            myObject.setValue_1(Double.parseDouble(tkn[8]));
            myObject.setValue_2(Double.parseDouble(tkn[9]));
            currentDeathValue = Integer.parseInt(tkn[10]);
            myObject.setDeath(currentDeathValue);

            if(flag && (previousDeathValue == currentDeathValue)){
                if(index < 3){
                    last3MyObject[index++] = myObject;
                }else{
                    flag = false;
                    for(MyObject mylast3Object  : last3MyObject){
                        System.out.println(mylast3Object);
                        fout.write(mylast3Object.toString().getBytes());
                        fout.write("\n".getBytes());
                    }

                }
            }

            if(currentDeathValue != previousDeathValue){
                flag = true;
                index = 0;
            }

            previousDeathValue = currentDeathValue;

            str = br.readLine();
        }