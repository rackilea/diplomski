public class PeriodConverter implements Converter {

    private Logger log;
    private static final long serialVersionUID = 1L;

    @Override
    public Object convertDataValueToObjectValue(Object str, Session session) {
        if (str == null) {
            log.info("convertDataValueToObjectValue returning null");
            return null;
        }
        return new Period(str);

    }

    @Override
    public Object convertObjectValueToDataValue(Object period, Session session) {
        /** str format should be: - `PyYmMwWdDThHmMsS` **/
        if (period == null) {
            log.info("convertObjectValueToDataValue returning null");
            return null;
        }
        return period.toString();
    }

    @Override
    public void initialize(DatabaseMapping mapping, Session session) {
        log = Logger.getLogger("com.joda.converter.PeriodConverter");
        ((AbstractDirectMapping) mapping).setFieldType(java.sql.Types.VARCHAR);
    }

    @Override
    public boolean isMutable() {
        return true;
    }
}