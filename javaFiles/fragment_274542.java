public static ArrayList<String> descriptions = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        File filename = new File("C:\\temp\\test.txt");
        loadDescriptions(filename);


        System.out.println("*************");
    for(String ln:descriptions){
        System.out.println(ln);
    }

    }

    public static void loadDescriptions(File name) throws IOException {
        FileReader fr = new FileReader(name);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        String line=null;

        while ((line = br.readLine()) != null ) {

            if(line.startsWith("@")){
                if(i>0){
                 descriptions.add(sb.toString());
                 sb = new StringBuilder();
                }

            }else{
               if(!line.isEmpty()){
                System.out.println(line);
                sb.append(" " + line);
              }
            }


            i++;

        }

    }