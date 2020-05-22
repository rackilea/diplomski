E:\users>javap oracle.sql.ArrayDescriptor
Compiled from "ArrayDescriptor.java"
public class oracle.sql.ArrayDescriptor extends oracle.sql.TypeDescriptor implem
ents java.io.Serializable{
    public static final int TYPE_VARRAY;
    public static final int TYPE_NESTED_TABLE;
    public static final int CACHE_NONE;
    public static final int CACHE_ALL;
    public static final int CACHE_LAST;
    static final long serialVersionUID;
    public static final boolean TRACE;
    public static final boolean PRIVATE_TRACE;
    public static final java.lang.String BUILD_DATE;
    public static oracle.sql.ArrayDescriptor createDescriptor(java.lang.String, java.sql.Connection) throws java.sql.SQLException;
    public static oracle.sql.ArrayDescriptor createDescriptor(java.lang.String, java.sql.Connection, boolean, boolean) throws java.sql.SQLException;
    public static oracle.sql.ArrayDescriptor createDescriptor(oracle.sql.SQLName,  java.sql.Connection) throws java.sql.SQLException;
    public static oracle.sql.ArrayDescriptor createDescriptor(oracle.sql.SQLName, java.sql.Connection, boolean, boolean) throws java.sql.SQLException;
    public static oracle.sql.ArrayDescriptor createDescriptor(oracle.jdbc.oracore.OracleTypeCOLLECTION) throws java.sql.SQLException;
    public oracle.sql.ArrayDescriptor(java.lang.String, java.sql.Connection) throws java.sql.SQLException;
    public oracle.sql.ArrayDescriptor(oracle.sql.SQLName, java.sql.Connection) throws java.sql.SQLException;
    public oracle.sql.ArrayDescriptor(oracle.sql.SQLName, oracle.jdbc.oracore.OracleTypeCOLLECTION, java.sql.Connection) throws java.sql.SQLException;
    public oracle.sql.ArrayDescriptor(oracle.jdbc.oracore.OracleTypeCOLLECTION, java.sql.Connection) throws java.sql.SQLException;
    static oracle.sql.ArrayDescriptor createDescriptor(oracle.sql.SQLName, byte[], int, byte[], byte[], oracle.jdbc.internal.OracleConnection, byte[]) throws java.sql.SQLException;
    public int getBaseType() throws java.sql.SQLException;
    public java.lang.String getBaseName() throws java.sql.SQLException;
    public oracle.jdbc.oracore.OracleTypeCOLLECTION getOracleTypeCOLLECTION();
    public int getArrayType() throws java.sql.SQLException;
    public long getMaxLength() throws java.sql.SQLException;
    public java.lang.String descType()  throws java.sql.SQLException;
    java.lang.String descType(java.lang.StringBuffer, int) throws java.sql.SQLException;
    int toLength(oracle.sql.ARRAY) throws java.sql.SQLException;
    byte[] toBytes(oracle.sql.ARRAY, boolean) throws java.sql.SQLException;
    oracle.sql.Datum[] toOracleArray(oracle.sql.ARRAY, long, int, boolean) throws java.sql.SQLException;
    java.lang.Object[] toJavaArray(oracle.sql.ARRAY, long, int, java.util.Map, boolean) throws java.sql.SQLException;
    public java.sql.ResultSet toResultSet(oracle.sql.ARRAY, long, int, java.util.Map, boolean) throws java.sql.SQLException;
    public java.sql.ResultSet toResultSet(oracle.sql.Datum[], long, int, java.util.Map) throws java.sql.SQLException;
    public java.sql.ResultSet toResultSetFromLocator(byte[], long, int, java.util.Map) throws java.sql.SQLException;
    public java.sql.ResultSet toResultSetFromImage(oracle.sql.ARRAY, long, int, java.util.Map) throws java.sql.SQLException;
    public static java.lang.Object[] makeJavaArray(int, int) throws java.sql.SQLException;
    oracle.sql.Datum[] toOracleArray(java.lang.Object, long, int) throws java.sql.SQLException;
    java.lang.Object toNumericArray(oracle.sql.ARRAY, long, int, int, boolean) throws java.sql.SQLException;
    public int getTypeCode() throws java.sql.SQLException;
    public byte[] toBytes(oracle.sql.Datum[]) throws java.sql.SQLException;
    public byte[] toBytes(java.lang.Object[]) throws java.sql.SQLException;
    public int length(byte[]) throws java.sql.SQLException;
    public oracle.sql.Datum[] toArray(byte[]) throws java.sql.SQLException;
    public oracle.sql.Datum[] toArray(java.lang.Object) throws java.sql.SQLException;
    public java.sql.ResultSet toResultSet(byte[], java.util.Map) throws java.sql.SQLException;
    public java.sql.ResultSet toResultSet(byte[], long, int, java.util.Map) throws java.sql.SQLException;
    public static int getCacheStyle(oracle.sql.ARRAY) throws java.sql.SQLException;
    static {};
}