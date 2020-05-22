while(rs.next())
   {
  product p = new product();
  p.setPname(rs.getString(1));
  p.setPrice(rs.getString(2));
  p.setImg(rs.getString(3));
   prod.add(p);
  }