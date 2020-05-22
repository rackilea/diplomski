E:\users>javap -private oracle.sql.TypeDescriptor
Compiled from "TypeDescriptor.java"
public abstract class oracle.sql.TypeDescriptor extends java.lang.Object implements java.io.Serializable{
    public static boolean DEBUG_SERIALIZATION;
    static final long serialVersionUID;
    oracle.sql.SQLName sqlName;
    oracle.jdbc.oracore.OracleNamedType pickler;
    transient oracle.jdbc.internal.OracleConnection connection;
    private static final java.lang.String _Copyright_2004_Oracle_All_Rights_Reserved_;
    public static final boolean TRACE;
    public static final boolean PRIVATE_TRACE;
    public static final java.lang.String BUILD_DATE;
    protected oracle.sql.TypeDescriptor();
    protected oracle.sql.TypeDescriptor(java.lang.String, java.sql.Connection)throws java.sql.SQLException;
    protected oracle.sql.TypeDescriptor(oracle.sql.SQLName, java.sql.Connection)throws java.sql.SQLException;
    protected oracle.sql.TypeDescriptor(oracle.sql.SQLName, oracle.jdbc.oracore.OracleTypeADT, java.sql.Connection)throws java.sql.SQLException;
    protected oracle.sql.TypeDescriptor(oracle.jdbc.oracore.OracleTypeADT, java.sql.Connection)throws java.sql.SQLException;
    public synchronized java.lang.String getName() throws java.sql.SQLException;
    public synchronized oracle.sql.SQLName getSQLName() throws java.sql.SQLException;
    void initSQLName()       throws java.sql.SQLException;
    public java.lang.String getSchemaName()       throws java.sql.SQLException;
    public java.lang.String getTypeName()       throws java.sql.SQLException;
    public oracle.jdbc.oracore.OracleNamedType getPickler();
    public oracle.jdbc.internal.OracleConnection getInternalConnection();
    public void setPhysicalConnectionOf(java.sql.Connection);
    public abstract int getTypeCode()       throws java.sql.SQLException;
    public static oracle.sql.TypeDescriptor getTypeDescriptor(java.lang.String,oracle.jdbc.OracleConnection) throws java.sql.SQLException;
    public static oracle.sql.TypeDescriptor getTypeDescriptor(java.lang.String,oracle.jdbc.OracleConnection, byte[], long) throws java.sql.SQLException;
    public boolean isInHierarchyOf(java.lang.String) throws java.sql.SQLException;
    private void writeObject(java.io.ObjectOutputStream)throws java.io.IOException;
    private void readObject(java.io.ObjectInputStream)throws java.io.IOException, java.lang.ClassNotFoundException;
    public void setConnection(java.sql.Connection) throws java.sql.SQLException;
    public static java.lang.String getSubtypeName(oracle.jdbc.OracleConnection,byte[], long) throws java.sql.SQLException;
    public void initMetadataRecursively()       throws java.sql.SQLException;
    public void initNamesRecursively()       throws java.sql.SQLException;
    public void fixupConnection(oracle.jdbc.internal.OracleConnection) throws java.sql.SQLException;
    public java.lang.String toXMLString()       throws java.sql.SQLException;
    public void printXML(java.io.PrintStream)       throws java.sql.SQLException;
    void printXML(java.io.PrintWriter, int)       throws java.sql.SQLException;
    void printXMLHeader(java.io.PrintWriter)       throws java.sql.SQLException;
    static {};
}