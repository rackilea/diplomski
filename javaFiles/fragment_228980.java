public Object unmarshal(HierarchicalStreamReader reader,
                        UnmarshallingContext context) {
    while (reader.hasMoreChildren()) {
        reader.moveDown();
        if("SecondLevel".equals(reader.getNodeName())){
            SecondLevel secondLevel =
                (SecondLevel)context.convertAnother(topLevel,
                    SecondLevel.class,
                    new SecondLevelConverter(topLevel));
            topLevel.add(secondLevel);
        }
        reader.moveUp();
    }
    return topLevel;
}