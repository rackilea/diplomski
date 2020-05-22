class XMLParsingSAX extends DefaultHandler {


    public static void main(String[] args) {
        new XMLParsingSAX().parseDocument();
    }

    private void parseDocument() {

        // get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            // get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            // parse the file and also register this class for call backs
            sp.parse("NewFile.xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }

        System.out.println(states.toString());
        System.out.println(states.get(0).getPoints().toString());
        System.out.println(states.get(1).getPoints().toString());
    }

    Points tempPoint;
    String tempVal1;
    String tempVal2;

    States tempState;

    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        // reset
        tempVal1 = "";
        tempVal2 = "";
        System.out.println("localName: " + localName + " qName: " + qName
                + " name: " + attributes.getValue(0));
        if (qName.equalsIgnoreCase("state")) {
            // create a new instance of state
            tempState = new States();
            points = new ArrayList<Points>();
            tempState.setStateName(attributes.getValue(0));
            tempState.setColor(Integer.parseInt(attributes.getValue(1)));
            tempVal1 = attributes.getValue(0);
            tempVal2 = attributes.getValue(1);
            System.out.println("localName: " + localName + " qName: "
                    + qName + " name: " + attributes.getValue(0) + " color: "
                    + attributes.getValue(1));

        } else if (qName.equalsIgnoreCase("point")) {
            // create a new instance of point
            tempPoint = new Points();
            tempVal1 = attributes.getValue(0);
            tempVal2 = attributes.getValue(1);
            System.out.println("localName: " + localName + " qName: "
                    + qName + " lat: " + attributes.getValue(0) + " lng: "
                    + attributes.getValue(1));
        }

    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("localName: " + localName + " qName" + qName);
        if (qName.equalsIgnoreCase("state")) {
            // add it to the list
//            tempState.setStateName(tempVal1); // getting Exception
//            tempState.setColor(Integer.parseInt(tempVal2));// getting Exception
            states.add(tempState);

        } else if (qName.equalsIgnoreCase("point")) {
            // add it to the list
            tempPoint.setLatitude(Long.parseLong(tempVal1));// getting Exception
            tempPoint.setLongitude(Long.parseLong(tempVal2));// getting Exception
            points.add(tempPoint);

        }
        tempState.setPoints(points);// getting Exception        
        System.out.println("" + states.size());
        System.out.println("" + points.size());

    }


       ArrayList<States> states = new ArrayList<States>();
       ArrayList<Points> points = new ArrayList<Points>();

}


 class States {
    private String stateName;
    private int color;
    private ArrayList<Points> points;

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public ArrayList<Points> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Points> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "States [stateName=" + stateName + ", color=" + color + "]";
    }


}


 class Points {

        private long latitude;
        private long longitude;

        public long getLatitude() {
            return latitude;
        }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public String getPointsDetails() {
        String result = latitude + ": " + longitude;
        return result;
    }

    @Override
    public String toString() {
        return "Points [latitude=" + latitude + ", longitude=" + longitude
                + "]";
    }


    }