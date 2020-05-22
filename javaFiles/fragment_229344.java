import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.tricode.mrc.ui.web.messages.Messages;

/**
 * 
 * @author Sinisa
 *
 * @param <T> the entity type
 */
public abstract class AbstractCrudForm<T extends Serializable> {

        private List<T> data;

        public AbstractCrudForm(List<T> data) {
                this.data = data;
        }

        /**
         * @param record
         * @return the value of the id field of the given record
         */
        protected abstract String getId(T record);

        /**
         * @return ui name of the entity that is displayed <br>i.e. for DataValidationConfiguration will return "Data Validation Configuration"
         */
        public abstract String getUserFriendlyTypeName();

        /**
         * @return the number of fields of the columns (fields)
         */
        public abstract int getNumberOfFields();

        /**
         * Return the column names as seen in the header of the crud table
         * @return
         */
        public abstract String[] getArrayOfColumnNames();

        /**
         * @param record
         * @param column
         * @return
         */
        protected abstract String getDataAtColumn(T record, int column);

        /**
         * Returns the data at the specified position
         * @param row
         * @param column
         * @return the data at the specified position
         */
        public String getDataAt(int row, int column) {
                return getDataAtColumn(data.get(row), column);
        }

        /**
         * @return a list of the data
         */
        protected List<T> getData() {
                return this.data;
        }

        /**
         * @return the user friendly name for the title of the ui form for editing
         */
        public String getUserFriendlyEditTypeName() {
                return Messages.getString("AbstractCrudForm.Edit") + getUserFriendlyTypeName(); //$NON-NLS-1$
        }

        /**
         * @return the user friendly name for the title of the ui form for editing
         */
        public String getUserFriendlySaveTypeName() {
                return Messages.getString("AbstractCrudForm.New") + getUserFriendlyTypeName(); //$NON-NLS-1$
        }

        /**
         * @return a list of the column names
         */
        public List<String> getColumns() {
                return Arrays.asList(getArrayOfColumnNames());
        }

        /**
         * @param position
         * @return the column name at a given position
         */
        public String getColumnNameAt(int position) {
                return getArrayOfColumnNames()[position];
        }

        /**
         * The result size
         * @return
         */
        public int resultsSize() {
                return data.size();
        }

        /**
         * @param row
         * @return the value of the id field for the given record
         */
        public String getId(int row) {
                return getId(data.get(row));
        }

}