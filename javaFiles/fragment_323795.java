List<String> objList = myManager.getList(bookId, bookName);
for(String t : objList)
{       
    if(!StringUtil.isBlank((String)t))
    {
        bookList.add(new book((String) t,(String) t));
    }
}