try {
                calcDate = dateFormat.parse(changeDate); 
            } catch (ParseException e) {
                try {
                     changeDate = changeDate.substring(0, 15);                      
                    calcDate = dateFormat2.parse(changeDate);
                } catch (ParseException e2) {
                     e2.printStackTrace();
                }
            }