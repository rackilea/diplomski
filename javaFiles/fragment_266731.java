public enum DataType {
    T_Null(TypeId.Unknown, "NULL", Types.NULL, 0, 0),
    T_Int8(TypeId.I1, "TINYINT", Types.TINYINT, 1, 4), 
    T_Int16(TypeId.I2, "SMALLINT", Types.SMALLINT, 2, 6), 
    T_Int32(TypeId.I4, "INTEGER", Types.INTEGER, 4, 11),
    T_Int64(TypeId.I8, "BIGINT", Types.BIGINT, 8, 20), 
    T_UInt8(TypeId.Ui1, "BYTE", Types.TINYINT, 1, 3), // 0 -> 255
    T_UInt16(TypeId.Ui2, "USHORT", Types.SMALLINT, 2, 5), // 0 -> 65535
    T_UInt32(TypeId.Ui4, "UINT", Types.INTEGER, 4, 10) // 0 -> 4294967295  
    ; 
    private final TypeId typeId;
    private final int sqlTypeCode, binSize, dispSize;
    private final String typeName;

    private DataType(TypeId typeId, String typeName, int sqlTypeCode, int binSize, int dispSize) {
      this.typeId = typeId;
      this.typeName = typeName;
      this.sqlTypeCode = sqlTypeCode;
      this.binSize = binSize;
      this.dispSize = dispSize;
    }
    public String getName() { return typeName; }
    // other getters 

    public static DataType ofType(TypeId typeId) {
        for (DataType dt : values())
            if (dt.typeId == typeId)
                return dt;
        return T_Null;
    }

};