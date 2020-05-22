boolean exists = false;
             for(int index =0;index<num.length;index++){
                 if(count == num[index]){

                     if(line.contains(VALUES1[index])){
                         exists = true;
                         line1= line.replace(VALUES1[index], VALUES[index]);
                          writer1.write(line1+System.getProperty("line.separator"));
                     }


                 }
             }

             if (!exists)
                 writer1.write(line+System.getProperty("line.separator"));