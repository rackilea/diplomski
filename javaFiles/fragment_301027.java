ArrayList<OSDHolder> holders = new ArrayList<>();

for (OSD osd:awbThingTypeOSDs) {
    holders.add(new OSDHolder(osd));
}

for (OSD osd:LDDthingTypeOSDs) {
    holders.add(new OSDHolder(osd));
}