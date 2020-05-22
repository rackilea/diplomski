while(rs.next())
 {
    for(j=0; j<3; j++)
    {
        attributes[j] = rs.getString(j);
    }
 }