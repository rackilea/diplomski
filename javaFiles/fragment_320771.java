RtSuperQuickMetadata rtSuperQuickMetadata = new RtSuperQuickMetadata();

List<RtSuperQuickMetadataItem> rtSuperQuickMetadataItems = new ArrayList<RtSuperQuickMetadataItem>();
rtSuperQuickMetadata.setRtSuperQuickMetadataItems(rtSuperQuickMetadataItems);

RtSuperQuickMetadataItem item = new RtSuperQuickMetadataItem();
rtSuperQuickMetadataItems.add(item);

ArrayList<Cite> cites = new ArrayList<Cite>();
Cite cite = new Cite();
cite.setCiteStr("MyCite");
cites.add(cite);
item.setCitesAffected(cites);

Marshaller m = jaxbContext.createMarshaller();
m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
m.marshal(rtSuperQuickMetadata, System.out);