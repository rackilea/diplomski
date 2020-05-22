public void saveTool() {

    toolDao.deleteAll();

    ToolDocument toolDocument1 = new ToolDocument();
    toolDocument1.setId(1L);
    toolDocument1.setName("wrench");
    toolDocument1.setMadeInCountry("germany");

    UsedIn usedIn1 = new UsedIn();
    usedIn1.setCarId(1L);
    usedIn1.setUsedByUsername("user");
    usedIn1.setUsedDate(new Date());

    List<UsedIn> usedIns1 = new ArrayList<>();
    usedIns1.add(usedIn1);

    toolDocument1.setUsedIn(usedIns1);

    toolDao.save(toolDocument1);
}