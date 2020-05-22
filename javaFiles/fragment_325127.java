public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Locations.class, Location.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("D:\\temp\\Settings.xml");
        Locations locations = (Locations) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(locations, System.out);
    }

    @XmlRootElement(name = "Locations")
    private static class Locations {
        List<Location> location;

        public List<Location> getLocation() {
            return location;
        }

        @XmlElement(name = "Location")
        public void setLocation(List<Location> myLocation) {
            this.location = myLocation;
        }
    }

    @XmlType(propOrder = { "value1", "value2", "value3" })
    private static class Location {
        String Value1;
        int Value2;
        String Value3;

        public String getValue1() {
            return Value1;
        }

        @XmlElement(name = "Value1")
        public void setValue1(String Value1) {
            this.Value1 = Value1;
        }

        public int getValue2() {
            return Value2;
        }

        @XmlElement(name = "Value2")
        public void setValue2(int Value2) {
            this.Value2 = Value2;
        }

        public String getValue3() {
            return Value3;
        }

        @XmlElement(name = "Value3")
        public void setValue3(String Value3) {
            this.Value3 = Value3;
        }
    }