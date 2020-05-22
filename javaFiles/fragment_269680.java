public void read() throws IOException {
        PerformCheck pc = new PerformCheck();
        Scanner sc = new Scanner(new File("input.txt"));
        sc.useDelimiter(",");
        String url = "";
        String res = "";
        boolean lock = true;
        ArrayList<String> tmp = new ArrayList<String>();
        while (sc.hasNext()) {
            String s = sc.next().trim();
            boolean isHttp=s.contains("http");
            if (isHttp && lock) {
                url = s;
                lock=false;
            } 
            else if (isHttp){
                   result= pc.perform(url,tmp);
                   url= s;
                   tmp= new ArrayList<String>();
                // Perform check here
                // url=s
                //tmp=new ArrayList<String>();
            }else {
                tmp.add(s);
            }

        }
        if (tmp.size()>0){
           result=pc.perform(url,tmp);
        }

        sc.close();
    }