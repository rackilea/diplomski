FileInputStream fin = new FileInputStream("C/inputFile.csv");
        FileOutputStream fout = new FileOutputStream("C/newCSV.csv");

        BufferedReader br = new BufferedReader(new InputStreamReader(fin));

        MyObject[] last3MyObject = new MyObject[3];
        int index = 0;
        String str = br.readLine();//read Filed Header Value...
        String fieldHeader = str;
        fout.write(fieldHeader.getBytes());//write header into output file...

        str = br.readLine();

        int currentDeathValue = 0;
        int previousDeathValue = 0;

        while(str != null){

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

            if(currentDeathValue != previousDeathValue){
                for(MyObject mylast3Object  : last3MyObject){

                    fout.write(mylast3Object.toString().getBytes());
                    fout.write("\n".getBytes());
                }
            }

            previousDeathValue = currentDeathValue;

            myObject.setDeath(currentDeathValue);

            if(index == 3){
                index = 0;
            }

            last3MyObject[index++] = myObject; 

            str = br.readLine();