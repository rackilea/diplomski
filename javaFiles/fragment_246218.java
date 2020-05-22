// Converter used to make sure XStream still able to read old version of XML
// files.
private static Converter getSimpleDateConverter() {
    return new Converter() {
        @Override
        public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
            SimpleDate simpleDate = (SimpleDate) o;
            writer.startNode("year");
            writer.setValue("" + simpleDate.getYear());
            writer.endNode();
            writer.startNode("month");
            writer.setValue("" + simpleDate.getMonth());
            writer.endNode();
            writer.startNode("day");
            writer.setValue("" + simpleDate.getDay());
            writer.endNode();
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
            Map<String, String> map = new HashMap<String, String>();
            while (reader.hasMoreChildren()) {
                reader.moveDown();
                map.put(reader.getNodeName(), reader.getValue());
                reader.moveUp();
            }
            // Introduce since version 1.0.6.
            // We had renamed 'date' field to 'day' field.
            final boolean isOldVersion = map.containsKey("date");
            if (isOldVersion) {
                final int year = Integer.parseInt(map.get("year"));
                // We changed 0 based month to 1 based month, to fit into Joda library.
                final int month = Integer.parseInt(map.get("month")) + 1;
                final int day  = Integer.parseInt(map.get("date"));
                return new SimpleDate(year, month, day);
            } else {
                final int year = Integer.parseInt(map.get("year"));
                final int month = Integer.parseInt(map.get("month"));
                final int day  = Integer.parseInt(map.get("day"));
                return new SimpleDate(year, month, day);
            }
        }

        @Override
        public boolean canConvert(Class type) {
            return SimpleDate.class.isAssignableFrom(type);
        }
    };
}