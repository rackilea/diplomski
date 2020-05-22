val get=client.prepareGet("Testdb","artWork",Id.toString())
        .setOperationThreaded(false)
        .setFields("uuid","StatusHistoryList",
            "ArtShare.TotalArtShares")
        .execute()
        .actionGet()
        if(get.isExists())
        {
        uuid=get.getField("uuid").getValue.toString().toInt
       var totalShares= get.getField("ArtShare.TotalArtShares" 
     }