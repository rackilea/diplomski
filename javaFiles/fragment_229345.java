import java.util.List;

import com.tricode.misterchameleon.model.DataValidationConfiguration;
import com.tricode.mrc.ui.web.AbstractCrudForm;
import com.tricode.mrc.ui.web.messages.Messages;

public class DataValidationConfigurationCrudForm extends AbstractCrudForm<DataValidationConfiguration> {

        public DataValidationConfigurationCrudForm(List<DataValidationConfiguration> data) {
                super(data);
        }

        @Override
        public String getTypeName() {
                return DataValidationConfiguration.class.getSimpleName();
        }

        @Override
        public String getUserFriendlyTypeName() {
                return Messages.getString("DataValidationConfigurationCrudForm.DataValidationConfiguration"); //$NON-NLS-1$
        }

        @Override
        public int getNumberOfFields() {
                // TODO take it with generics
                return 8;
        }

        @Override
        public String[] getArrayOfColumnNames() {
                return new String[] {
                                Messages.getString("DataValidationConfigurationCrudForm.ID"), Messages.getString("DataValidationConfigurationCrudForm.DomainName"), Messages.getString("DataValidationConfigurationCrudForm.FormUrl"), Messages.getString("DataValidationConfigurationCrudForm.PostalCode"), Messages.getString("DataValidationConfigurationCrudForm.HouseNumber"), Messages.getString("DataValidationConfigurationCrudForm.Street"), Messages.getString("DataValidationConfigurationCrudForm.City"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
                                Messages.getString("DataValidationConfigurationCrudForm.Country") }; //$NON-NLS-1$
        }

        @Override
        protected String getDataAtColumn(DataValidationConfiguration config, int column) {
                switch (column) {
                case 0:
                        return config.getId().toString();
                case 1:
                        return config.getDomainName();
                case 2:
                        return config.getFormUrl();
                case 3:
                        return config.getPostalCode();
                case 4:
                        return config.getHouseNumber();
                case 5:
                        return config.getStreet();
                case 6:
                        return config.getCity();
                case 7:
                        return config.getCountry();
                default:
                        throw new IllegalArgumentException(Messages.getString("DataValidationConfigurationCrudForm.YouShouldntHaveGottenHere")); //$NON-NLS-1$
                }
        }

        @Override
        protected String getId(DataValidationConfiguration record) {
                return record.getId().toString();
        }

}