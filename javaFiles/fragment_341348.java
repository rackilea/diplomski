List results = template.queryForList(sql);

for (Map m : results){
   m.get('userid');
   m.get('username');
}