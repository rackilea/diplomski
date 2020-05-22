NodeList l = null;
NodeList n = null;
int counter = 0;
for (counter = 0; counter < files.size(); counter++) {
     Document d   =DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(files.get(counter));
         l = d.getElementsByTagName("Booking");
         n = d.getElementsByTagName("BookTripPlanOutput");
        for (int i = 0; i < l.getLength(); ++i) {
                GMFiles.add(files.get(i));
                processGMXml(GMFiles, prop, log);

        }
        for (int a = 0; a < n.getLength(); ++a) {
                ACFiles.add(files.get(a));
                processACXml(ACFiles, prop, log);
         }
    }