// Using this static import
import static org.jooq.impl.DSL.*;

// Assuming a VARCHAR column in the database:
DataType<MyType> type = SQLDataType.VARCHAR.asConvertedDataType(
    new MyConverter<String, MyType>());
Field<MyType> field = field(name("MY_TABLE", "MY_FIELD"), type);