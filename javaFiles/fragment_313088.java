@Select("SELECT T.OBJECT_ID," +
        "T.STRUCTURE_CODE," +
        "T.TYPE," +
        "T.NAME," +
        "T.LENGTH," +
        "T.WIDTH," +
        "T.HEIGHT," +
        "T.WEIGHT," +
        "T.REMARK," +
        "dbms_lob.substr(T.GEOM.GET_WKT(),4000) geom " +
        "FROM JZW_BRIDGE_POINT T WHERE T.STRUCTURE_CODE = #{structureCode}")
Bridge getBridgeByStructureCode(@Param("structureCode") String structureCode);