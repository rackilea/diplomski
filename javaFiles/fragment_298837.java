System.out.println("Enter name:");
        Scanner scan=new Scanner(System.in);
        String name=scan.nextLine();
        System.out.println("Enter age:");
        int age=scan.nextInt();
        String query="insert into table1(Stuname,Age) values(?,?);";
        ps=conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setInt(2,age);

       // you have forget to submit your changes to the database. try with following line of code
        ps.execute() or ps.executeQuery()

        conn.commit();