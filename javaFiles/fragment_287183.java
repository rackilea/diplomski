private static class MapEntryConverter implements Converter {
        public boolean canConvert(Class clazz) {
            return clazz.equals(Employees.class);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
            AbstractMap<String, String> map = (AbstractMap<String, String>) value;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.startNode(entry.getKey().toString());
                writer.setValue(entry.getValue().toString());
                writer.endNode();
            }
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map<String, String> map = new HashMap<String, String>();

            while (reader.hasMoreChildren()) {
                reader.moveDown();
                map.put(reader.getAttribute(1), reader.getValue());
                reader.moveUp();
            }
            return map;
        }
    }