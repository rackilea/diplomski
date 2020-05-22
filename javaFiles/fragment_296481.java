public static String readAllLayoutFiles ( ){

    File layoutDir = new File( LAYOUT_PARENT_DIR );

    String allFiles[] = layoutDir.list();
    System.out.println( "All Files Length : " + allFiles.length );
    JSONObject obj = null;//new JSONObject[ allFiles.length ];

    JSONArray retArr = new JSONArray();

    for ( String f : allFiles ){
        obj= new JSONObject();
        obj.put( "layoutname", f.replaceAll (".txt", "" ) );
        obj.put( "layouthtml", readLayoutFile ( f ) );
        retArr.add(obj);
    }
    obj= new JSONObject();
    obj.put( "isSuccessful", true );
    retArr.add(obj);

    System.out.println( retArr.toJSONString() );
    return retArr.toJSONString();
}