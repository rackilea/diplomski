"select sitename, description from  product  WHERE sitename LIKE '%"+s1+"%' UNION 

 select sitename, description from  sports   WHERE sitename LIKE '%"+s1+"%' UNION

 select sitename, description from  website  WHERE sitename LIKE '%"+s1+"%' UNION

 select sitename, description from  software  WHERE sitename LIKE '%"+s1+"%' UNION

 select sitename, text as description from   other   WHERE sitename LIKE '%"+s1+"%'" ;