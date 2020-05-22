char[] options = {'F','Z','P','E','N','T','L','C','D','O'};
    char[] result =  new char[70];
    Random r=new Random();
    for(int i=0;i<result.length;i++){
        result[i]=options[r.nextInt(options.length)];
    }