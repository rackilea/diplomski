if (property.getType().equals("Integer")) {
        // we have made sure property is of class Property<Integer> so the cast is type safe
        @SuppressWarnings("unchecked")
        Property<Integer> propInt = (Property<Integer>) property;
        propInt.setValue((Integer) values[i++]);
}