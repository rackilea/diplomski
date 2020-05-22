while(rs.length > 0 && !rs[0].isAfterLast()){
    for (int i = 0; i < NUM_RECORDSETS; i++){
        rs[i].next();
        //get stuff from this recordset
    }
}