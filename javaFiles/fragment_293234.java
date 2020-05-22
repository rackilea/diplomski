public static String[][] getModel(String answer){
     try {
         System.out.println(answer);
             if(answer.contains("|")){
                            String[] cols=answer.split(",\\|");

                            System.out.println("case found");
                            System.out.println("size 1:"+cols.length);

                            int dimensionCol=cols.length;
                            int dimensionRow=cols[0].split(",").length;

                            System.out.println(dimensionCol+" "+dimensionRow);
                            String[][] result=new String[dimensionRow][dimensionCol];

                            int i=0,j=0;
                            for(String colElement:cols){
                                i=0;
                                String[] datas = colElement.split(",");
                                for (String data : datas) {
                                    result[i][j]=(!data.equals(""))?data:null;
                                    System.out.print(result[i][j]);
                                    i++;
                                }
                                System.out.println("");
                                j++;
                                         }
                            return result;
                           }else{


                                  System.out.println("empty String return by null");
                                  return null;


                           }
          }catch(Exception e){e.printStackTrace();}
     return null;
   }