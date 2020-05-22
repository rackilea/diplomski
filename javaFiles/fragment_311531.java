public class Customer extends TableImpl<CustomerRecord> {
    public final TableField<CustomerRecord, CustomerNo> ID = 
      createField("ID", SQLDataType.BIGINT.asConvertedDataType(new CustomerNoConverter()), this);
    ...

    // Your additional genererated code here
    public static class CustomerNo {
        public final Long ID;
    }

    public static class CustomerNoConverter implements Converter<Long, CustomerNo> {
        ...
    }
}