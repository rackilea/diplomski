CsvToBean<BeanType> csv2Bean = new CsvToBean<BeanType>() {

    @Override
    protected Object convertValue(String value, PropertyDescriptor prop) {
        return super.convertValue(value.toUpperCase(), prop);
    }
};

List<BeanType> beanList = csv2Bean.parse(mappingStrategy, csvReader);