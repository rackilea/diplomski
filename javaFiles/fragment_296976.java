@Converter
public class ConverterListInteger implements AttributeConverter<List<Integer>, Array>{

    @Override
    public Array convertToDatabaseColumn(List<Integer> attribute) {
        DataSource source = ApplicationContextHolder.getContext().getBean(DataSource.class);

        try {
            Connection conn = source.getConnection();
            Array array = conn.createArrayOf("integer", attribute.toArray());
            return  array;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Integer> convertToEntityAttribute(Array dbData) {
        List<Integer> list = new ArrayList<>();

        try {
            for(Object object : (Object[]) dbData.getArray()){
                list.add((Integer) object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }

}