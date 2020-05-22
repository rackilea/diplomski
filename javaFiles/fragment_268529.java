try{
        FileReader fr = new FileReader(fileName);
        Scanner sc = new Scanner(fr);
        while(sc.hasNextLine()){
            Student stud = new Student(sc.nextLine());
            line = stud.toString();
        }