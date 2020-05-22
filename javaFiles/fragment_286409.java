@Override  
public String getphone(long name,String address){ 
     List<EntityABC> entityList = getHibernateTemplate().find("from Table where name=" + name+"AND address='" + address+"'");

if(null!=entityList && entityList.size() >0){
     return phoneNumberList.get(0).getPhone();
}

return null;
}