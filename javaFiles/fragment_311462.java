int index = 0;
 while(rs.next())
            {
                catOther[index][0]=rs.getInt("productId");
                catOther[index][1]=rs.getString("productName");
                catOther[index][2]=rs.getFloat("cost");
                catOther[index][3]=rs.getString("trademark");
                catOther[index][4]=rs.getString("description");
                catOther[index][5]=rs.getString("category");                 
index++;
            }