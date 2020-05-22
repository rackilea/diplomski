public static class PublicProcessLineCsvToBean<T> extends CsvToBean<T> {

        @Override
        public T processLine(MappingStrategy<T> mapper, String[] line) throws IllegalAccessException, InvocationTargetException, InstantiationException, IntrospectionException {
            return super.processLine(mapper, line);
        }
    }