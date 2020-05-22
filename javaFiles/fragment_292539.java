Map<Date, PottyCollection> map = new HashMap<>();
for (PottyCollection pc : originalList) {
    PottyCollection existing = map.get(pc.dateHappened);
    if (existing == null) {
        map.put(pc.dateHappened, pc);
    }
    else {
        map.put(pc.dateHappened, new PottyCollection(pc.dateHappened, pc.pottyUses + existing.pottyUses));
    }
}
Collection<PottyCollection> reduced = map.values();