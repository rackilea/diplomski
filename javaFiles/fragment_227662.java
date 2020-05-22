sql_stmt_1.executeUpdate(
        " INSERT INTO " + strDBName + ".[dbo].Product ([Name] ,"
      + "[RG_ID],[WG_ID],[Parent_Product]) "
      + " SELECT '" + arrListLevel_1_Unique.get(iCount) + "',"
      + (intWG_ID + intRowIncrement) + ", "
      + (intWG_ID + intRowIncrement + 1) + ", 5828 "
      + " WHERE NOT EXISTS( SELECT 1 FROM " + strDBName
      + ".[dbo].Product WHERE [Name] LIKE '"
      + arrListLevel_1_Unique.get(iCount) + "') "
    ) ;