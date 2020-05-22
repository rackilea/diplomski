while((nextLine = reader.readNext()) != null){
             i++;
                // Remember length 3 = index 2
                if (nextLine.length == 3){
                    pstmt.setString(1,nextLine[0]);
                    //I have changed it to 2 from 1 
                    pstmt.setString(2,nextLine[1]);
                    pstmt.setDouble(2,Double.parseDouble(nextLine[2]));
             }
    }