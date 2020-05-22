import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;

public class CustomPostgresqlDataTypeFactory extends PostgresqlDataTypeFactory{

    @Override
    public DataType createDataType(int sqlType, String sqlTypeName, String tableName, String columnName) throws DataTypeException {
        if (sqlType == 2003) {
            if (sqlTypeName.equals("_text"))
                return new ArrayDataType(sqlTypeName, sqlType, false);
            if (sqlTypeName.contains("int"))
                return new ArrayDataType(sqlTypeName, sqlType, true);

            throw new UnsupportedSqlTypeException("Unsupported sql type: " + sqlTypeName);
        }

        return super.createDataType(sqlType, sqlTypeName, tableName, columnName);
    }
}