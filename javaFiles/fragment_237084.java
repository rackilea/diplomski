for(int i=start;i<stop;i++){
            double[][] forvariance = new double[(demos.length-1)][numsims];
            trnsnpv = new double[numsims][demos.length][demos.length-1];
            int size = 0;
            Long hhids1;
            Double outlierwt;
            String fbdemos;
            String trudemos;
            rstru = st.executeQuery("select TRUTH_DEMO_ID, FB_DEMO_ID, RN_ID, OUTLIER_WEIGHT from SCRATCH.."+months+"monthtable where BRAND_ID = " + brands[i]+" order by RN_ID");
            while (rstru.next()) {//Get query results and put them into a hash map.
                String temp0 = rstru.getString(1);String temp1 = rstru.getString(2);String temp2 = rstru.getString(3);String temp3 = rstru.getString(4);
                hhids1 = (Long.parseLong(temp2.substring(0,11)));
                fbdemos = (temp1);
                trudemos = (temp0);
                outlierwt = (Double.parseDouble(temp3));
                for(int sim=0;sim<numsims;sim++){
                    HashMap<Long,Integer> thissampl = bootsampl2.get(sim);
                    if(thissampl.containsKey(hhids1))
                        trnsnpv[sim][dems.get(fbdemos)][dems.get(trudemos)-1] += outlierwt*(double)thissampl.get(hhids1);
                }
                size++;
            }
            System.out.print("Processing: " + size + " rows");
            for(int sim=0;sim<numsims;sim++){
                for(int j=0;j<trnsnpv[sim].length;j++){//27 rows
                    trnsnpv[sim][j] = normalize(trnsnpv[sim][j]);
                    for(int k=0;k<trnsnpv[sim][j].length;k++){//26 columns
                        forvariance[k][sim] += trnsnpv[sim][j][k];
                    }
                }
            }
            for(int k = 0; k < (demos.length - 1); k++){
                double d = StdStats.var11(forvariance[k]);
                fileIO.fileIO.write2file(brands[i] + "," + demos[k+1] + "," + String.valueOf(d) + "\n", "vars.csv");
            }
            System.out.print("Brands processed: " + String.valueOf(i-start + 1 ) + " out of: " + (stop-start) + "\n");
            //hhids1.clear();outlierwt.clear();fbdemos.clear();trudemos.clear();
        }