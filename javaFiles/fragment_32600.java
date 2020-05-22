val get=client.prepareGet("Testdb","artWork",Id.toString())
    .setOperationThreaded(false)
    .setFields("uuid","ArtShare","StatusHistoryList"
        )
    .execute()
    .actionGet()
    if(get.isExists())
    {
    uuid=get.getField("uuid").getValue.toString().toInt
   //how to fetch `artShare` whole nested document and array elements `StatusHistoryListof`  
 }