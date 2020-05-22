AbstractColumn columnClientLocation = ColumnBuilder.getNew().setCustomExpression(
    return new CustomExpression() {
        public Object evaluate(Map fields, Map variables, Map parameters) {
            String clientAddress = (String) fields.get("ClientAddress");
            String clientCity = (String) fields.get("ClientCity");
            String clientPostalCode = (String) fields.get("ClientPostalCode");
            return clientAddress + ", " + clientCity + ", " + clientPostalCode;
        }

        public String getClassName() {
            return String.class.getName();
        }
    }
).build();