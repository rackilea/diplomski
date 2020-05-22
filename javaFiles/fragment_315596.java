String strDate="2013/7/7";
                String[] strsplit=strDate.split("/");
                int year=Integer.parseInt(strsplit[0]);
                int month=Integer.parseInt(strsplit[1]);
                int day=Integer.parseInt(strsplit[2]);

                if((month)<=9)
                    strDate+="0";
                strDate+=(month )+"/";
                if(day<=9)
                    strDate+="0";
                strDate+=(day)+"/";
                strDate+=(year);