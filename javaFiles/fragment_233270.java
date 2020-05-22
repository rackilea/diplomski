while (scanner.hasNextLine()){

        String line = scanner.nextLine();

        if(line.startsWith("*star")){

        String[] split= line.split("\\s+"); //Split the string where there is whitespace

        //No whitespace after *star 
        if ((split.length<2)){
        System.exit(0); 
        }

        String file= split[1];
        String star=split[0];

        String file1=file.trim(); //Removes whitespace 

        if(file1.startsWith("\"")&&(file1.endsWith("\""))){

        System.out.println(file1);
        }

   }