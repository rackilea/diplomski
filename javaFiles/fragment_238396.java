String s ="select 1;r;select \\2; select 3\\;copy customer from 's3://mybucket/mydata' credentials 'aws_access_key_id=<access-key-id>\\;aws_secret_access_key=<secret-access-key>\\;master_symmetric_ke‌​y=<master-key>'";
               //"select 1;r;select \\2; select 3\\;copy customer from 'r;s3://mybucket/mydata;r' credentials 'a_key;b_key;c_key\\;r' 'aws_access_key_id=access_key\\;aws_secret_access_key=secret_key\\;master_symmetric_key=master_key'";
       s = s.replace("\\","\\\\");
       List<String> tokens = new ArrayList<String>();               
       int i = 0;    
       int j = 0;
       String backup = s;
       while (i < s.length()){
        char c  = s.charAt(i);      
          if(c==';'){
            String previous = s.substring(0,i);
            int quotesBefore = StringUtils.countMatches(backup.substring(0,j), "'");
            if(i<2 || quotesBefore==0 || (i>1 && (quotesBefore & 1) == 0 || ((quotesBefore & 1) != 0) && !(s.charAt(i-1)=='\\' && s.charAt(i-2)=='\\'))){//Even quotes before OR (odd quotes AND not \\ right before)                 
                tokens.add(previous);
                if(i>0)s=s.substring(i+1);
                i=0;
            }
          }
          i++;j++;
        }
        tokens.add(s);
        for(String t : tokens) {
            System.out.println("> "+t);
        }