Path inputFile = Paths.get(args[0]);

    try{
        ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(inputFile, Charset.defaultCharset());
        ArrayList<String []> columns = new ArrayList<>();
        for(String line : lines){
            if(line.matches("^[0-9]")){
                System.out.println("Line:"+line);
                String[] colms = line.split("\\s+");
                    columns.add(colms);
                for (int i = 0; i < colms.length; i++) {
                    String temp = colms[i];
                    System.out.println("Colmns:"+i+":"+temp);
                    // process temp one by one
                }
            }
        }
    }catch(Exception ex){
        ex.printStackTrace();
        System.out.println("Exception...");
    }