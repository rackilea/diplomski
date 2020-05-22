public class CustomHSQLDialect extends HSQLDialect {

    public CustomHSQLDialect() {
        super();

        // overrides the default implementation of "pg-uuid" to replace it
        // with varchar-based storage.
        addTypeOverride(new UUIDCharType() {
            @Override
            public String getName() {
                return "pg-uuid";
            }
        });
    }
}