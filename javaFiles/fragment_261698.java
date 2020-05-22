public List<JunctionManagementListDto> getJunctionManagementList(String zoneName, Integer customerId) {     
String hql =    "SELECT new (packagename).JunctionManagementListDto(c.siteId, c.name, c.ip, c.customer.id, zm.zone.name) "
        +"FROM Controllers c, ZoneControllerMapping zm "
        +"WHERE c.siteId = zm.controller.siteId  ";

if(zoneName != "")
    hql += "  and zm.zone.name='"+zoneName+"' ";
 if (customerId!=null)
    hql += "  and zm.controller.customer.id='"+customerId+"' ";
return super.readListByHql(hql);        
}