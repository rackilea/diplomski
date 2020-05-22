public static String dates = "11/23 10:54:09 - 11/23 10:54:44";
        public static Pattern pattern = Pattern.compile("\\d\\d\\/\\d\\d \\d\\d:\\d\\d:\\d\\d");

        public boolean isDateOk() throws Exception {
            Matcher m = pattern.matcher(dates);
            SimpleDateFormat format = new SimpleDateFormat("MM/dd HH:mm:ss");
            Date startDate = null;
            Date endDate = null;
            Date ourDate = new Date();
            if(m.find()){
                startDate = format.parse(m.group());
            } else{
            throw new Exception("msg");
            }
            if(m.find()){
                endDate = format.parse(m.group());
            }else{
            throw new Exception("msg");
            }
            if (startDate!=null && endDate != null) {
                if (ourDate.after(startDate) && ourDate.before(endDate)){
                    return true;
                }
                return false;
            }


            return false;   
        }