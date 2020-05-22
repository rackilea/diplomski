Item i1 = new Item();
i1.setName("item 1");
i1.setId("1");

Item i2 = new Item();
i2.setName("item 2");
i2.setId("2");

Items items = new Items();
items.getItem().addAll(Arrays.asList(i1, i2));

Site s1 = new Site();
s1.setHost("1");
s1.setName("1");
s1.setPort("80");
s1.setSsl("true");
s1.setItems(items);

Site s2 = new Site();
s2.setHost("2");
s2.setName("2");
s2.setPort("80");
s2.setSsl("true");
s2.setItems(items);

Report r = new Report();
r.setBy("hans");
r.setDesc("version is alpha");
r.setFor("pepe");
r.setReportDate(DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-02-28T18:36:33"));
r.setReportVersion("version is alpha");
r.setScanDate(DatatypeFactory.newInstance().newXMLGregorianCalendar("2016-02-28T18:36:33"));
r.setScanVersion("original version");
r.setTitle("my custom title");
r.getSite().addAll(Arrays.asList(s1, s2));