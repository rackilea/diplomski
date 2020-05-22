public String readLine(){
        StringBuffer line =new StringBuffer();
        try{
            FileReader fr = new FileReader(fileName);
            Scanner sc = new Scanner(fr);
            while(sc.hasNextLine()){
                Student stud = new Student(sc.nextLine());
                line.append(stud.toString());
                line.append("\n");
            }
            fr.close();
        }catch(FileNotFoundException exception){
            System.out.println("File " + fileName + " was not found");
        }catch(IOException exception){
            System.out.println(exception);
        }
        return line.toString();
    }