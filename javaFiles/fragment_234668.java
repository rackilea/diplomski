public class MyUser implements SQLData, Serializable
{
    private static final long serialVersionUID = -4235126659654360181L;
    public String name;
    public String address;
    public String phone;
    private String sql_type;

    public MyUser(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return sql_type;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        sql_type = typeName;
        name = stream.readString();
        address = stream.readString();
        phone = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(name);
        stream.writeString(address);
        stream.writeString(phone);
    }
}