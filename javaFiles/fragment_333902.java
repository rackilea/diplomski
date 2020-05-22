@RunWith(JUnitParamsRunner.class)
public class PersonTest {

    @Test
    @FileParameters(value = "src\\junitParams\\test.csv", mapper = MyMapper.class)
    public void loadParamsFromFileWithIdentityMapper(int col1, int col2, int col3, int col4, int col5) {
        System.out.println("col1 " + col1 + " col2 " + col2 + " col3 " + col3 + " col " + col4 + " col5 " + col5);
        assertTrue(col1 > 0);
    }

    public static class MyMapper extends IdentityMapper {

        @Override
        public Object[] map(Reader reader) {
            Object[] map = super.map(reader);
            List<Object> result = new LinkedList<>();
            int numberOfColumns = ((String) map[0]).split(",").length;
            for (Object lineObj : map) {
                String line = (String) lineObj;
                int numberOfValues = line.split(",").length;
                line += StringUtils.repeat(",0", numberOfColumns - numberOfValues);
                result.add(line);
            }
            return result.subList(1, result.size()).toArray();
        }
    }
}