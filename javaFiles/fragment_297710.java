Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from test");
        while(rs.next()){
            System.out.println(rs.getString("name"));
            con.close();
        }
        }catch(Exception e){
        }