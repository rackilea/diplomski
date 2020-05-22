public class MyCraftLivingEntity extends CraftLivingEntity {

    @Override // just a marker annotation to help catch inheritance issues
    public void setCustomName(String name) {

         super.setCustomName(name);

         // do whatever else
    }
}