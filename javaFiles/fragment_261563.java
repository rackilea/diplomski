public Cursor query(Uri uri, String[] arg1, String arg2, String[] arg3,String arg4) 
{
    switch (uriMatcher.match(uri)) 
    {
    case 1:         
       CPcursor =  DBConnection.rawQuery("Enter your SQL query Here"')", null);
        break;
}
}