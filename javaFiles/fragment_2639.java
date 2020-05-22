import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDbUtility {
    private MyDbUtility(){}
    public static int[] maxColumns(final ResultSet resultSet) throws SQLException {
        int columnNumber = resultSet.getMetaData().getColumnCount();
        int[] max = new int[columnNumber];
        int currentRow = resultSet.getRow();
        int fetchDirection = resultSet.getFetchDirection();
        if (fetchDirection == ResultSet.FETCH_FORWARD) {
            resultSet.beforeFirst();
        }else {
            resultSet.afterLast();
        }

        while (resultSet.next()) {
            for (int i = 1; i <= columnNumber; i++) {
                if (resultSet.getString(i).length() > max[i-1]) {
                    max[i-1] = resultSet.getString(i).length();
                }
            }
        }
        resultSet.absolute(currentRow);
        return max;
    }
}