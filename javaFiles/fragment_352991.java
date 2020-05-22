public void addColumn(String path,String fileName) throws IOException{
    BufferedReader br=null;
    BufferedWriter bw=null;
    final String lineSep=System.getProperty("line.separator");

    try {
        File file = new File(path, fileName);
        File file2 = new File(path, fileName+".1");//so the
                    //names don't conflict or just use different folders

        br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
        String line = null;
                    int i=0;
        for ( line = br.readLine(); line != null; line = br.readLine(),i++)
        {               

            String addedColumn = String.valueOf(data.get(i));
            bw.write(line+addedColumn+lineSep);
    }

    }catch(Exception e){
        System.out.println(e);
    }finally  {
        if(br!=null)
            br.close();
        if(bw!=null)
            bw.close();
    }

}