while(rssize.next())
{   
  System.out.println("inside resultset");            
  JSONObject jobj = new JSONObject();  
  sizeid = rssize.getInt("SizeId");
  size=rssize.getString("Size");  
  System.out.println(size);
  jobj.put("SizeId", sizeid);
  jobj.put("Size", size);                        
  jArraysize.add(jobj);
}
if (jArraysize.length > 0)
{
  usesfactors.put("Size", jArraysize);
}
else
{
  System.out.println("Does not have Size factors");
}
rssize.close();