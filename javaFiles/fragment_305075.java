Date date1 = null; 
if((rs.getString(8)!=null) && (!"".equals(rs.getString(8))))
{    
 date1 = df.parse(rs.getString(8)); 
}  

Date date2 = null; 
if((rs.getString(9)!=null) && (!"".equals(rs.getString(9))))
{    
 date2 = df.parse(rs.getString(9)); 
}