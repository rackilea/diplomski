public static interface ElectricItem extends Item<ElectricItem>{}

public static class LightBulb implements ElectricItem{
    @Override
    public LightBulb Copy() {
        return new LightBulb();
    }
}

public static class Electrician extends RepairMan<ElectricItem>{
    ElectricItem itemNeedingRepairs; // Only electric Items acceptable
    public Electrician(ElectricItem item) {
        super(item);
    }
}

public static void main(String[] argc){
    LightBulb bulb = new LightBulb();
    new Electrician(bulb);
}