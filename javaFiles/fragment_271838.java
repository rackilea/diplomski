XStream xStream = new XStream();
xStream.alias("reportUnit", ReportUnit.class);
xStream.registerConverter(
            new com.thoughtworks.xstream.converters.basic.DateConverter("yyyy-MM-dd'T'HH:mm", new String[] {"dd/MM/yyyy HH:mm"},new GregorianCalendar().getTimeZone()){
              public boolean canConvert(Class type) {
                    return type.equals(Date.class) || type.equals(Timestamp.class);
              }
              public String toString(Object obj) {
                  return new SimpleDateFormat("yyyy-MM-dd HH:mm").format((Date) obj);
              }
        });

xStream.fromXML(objectXml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", BLANK));