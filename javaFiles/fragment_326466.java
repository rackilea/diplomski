try {
            //System.out.println("try successfully:");

        try {



        Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raptor1_5","root","");


        //Set<String> keySet = fileMap.keySet();
        //Set<String> fileName = keySet;
        int listgetcount = 0;
        int count2 =5;
        for (int k=0;k<5;k++) {
            System.out.println("for successfully:");
        String sql ="INSERT INTO tbl_MatchImgToImg (Class, Subject, CreatedBy, QimgName, Qimg, AimgName, Aimg) values (?, ?, ?, ?, ?, ?, ?)" ; 
        PreparedStatement statement;

            statement = con.prepareStatement(sql);

             statement.setString(1, clas);      
             statement.setString(2, subject);
             statement.setString(3, uid); 
             System.out.println("Qimg name is:"+listGet.get(listgetcount));
             statement.setString(4, listGet.get(listgetcount));    

             System.out.println("Qimg is:"+fileMap.values().toArray()[listgetcount]);
             Object bb = fileMap.values().toArray()[listgetcount];
            // System.out.println("Qimg is:"+listGet2.get(listgetcount));

            // System.out.println("finallyyyy:"+fileMap.get("files1"));
             statement.setBinaryStream(5, (InputStream) bb);


             System.out.println("Aimg name is:"+listGet.get(count2));
             statement.setString(6, listGet.get(count2));    

             System.out.println("Aimg is:"+fileMap.values().toArray()[count2]);
             Object bb2 = fileMap.values().toArray()[count2];
             //System.out.println("Qimg is:"+fileMap.get("files2"));
             //String getval2 = listGet2.get(count2);
             statement.setBinaryStream(7, (InputStream) bb2);


            int row = statement.executeUpdate();

            System.out.println("inserted successfully:");
            listgetcount = listgetcount+1;
            count2=count2+1;
        }
        listgetcount=0;
        }