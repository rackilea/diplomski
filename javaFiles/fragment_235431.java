public static class RepairMan {
    Item<?> itemNeedingRepairs; // Any Item is acceptable
    public RepairMan(final Item<?> item) { // Any Item is acceptable
        itemNeedingRepairs = item.Copy();
    }       
}