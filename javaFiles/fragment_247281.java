public double[][] populateArray(int scan1Count){
            double[] outputArray1 = new double[scan1Count];
            double[] outputArray2 = new double[scan1Count];
            double[] outputArray3 = new double[scan1Count];
            double[] outputArray4 = new double[scan1Count];


            //Read File Line By Line
            try {
                File tempfile = new File("samedatafile.txt");
                FileInputStream fis = new FileInputStream(tempfile);
                DataInputStream in = new DataInputStream(fis);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));      
                String strLine;
                int i = 0;
                while ((strLine = br.readLine()) != null)   {
                      Pattern pattern = Pattern.compile("-{0,1}\\d+.\\d+,-{0,1}\\d+.\\d+,-{0,1}\\d+.\\d+,-{0,1}\\d+.\\d+,");
                      Matcher matcher = pattern.matcher(strLine);
                      if (matcher.matches()){
                          String[] split = strLine.split(",");              
                          outputArray1[i] = Double.parseDouble(split[0]);
                          outputArray2[i] = Double.parseDouble(split[1]);
                          outputArray3[i] = Double.parseDouble(split[2]);
                          outputArray4[i] = Double.parseDouble(split[3]);
                      }
                      i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            double[][] temp = new double[4][];
            temp[0]= outputArray1;
            temp[1]= outputArray2;
            temp[2]= outputArray3;
            temp[3]= outputArray4;
            return temp;
        }