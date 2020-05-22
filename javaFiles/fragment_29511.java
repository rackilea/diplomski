BasicDBList bookmark_list = new BasicDBList();
List<Bookmark> bmk_list = userList.get(i).getBookmarksList();
for(int i=0;i<bmk_list.size();i++)
{
String name = bmk_list.get(i).getName();
String category = bmk_list.get(i).getCategory();
String stats = bmk_list.get(i).getStats();
boolean tried = bmk_list.get(i).getTried();
DBObject db_obj = new BasicDBObject();
db_obj.put("name",name);
db_obj.put("category",category);
db_obj.put("stats",stats);
db_obj.put("tried",tried);
bookmark_list.add(db_obj);
}