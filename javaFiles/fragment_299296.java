class C1 {
    private AEntityDefinition aEntityDefinition;
    public C1(){
        aEntityDefinition = new AEntityDefinition();
        aEntityDefinition.setEntity(new Course("Course","Course code"));
    }

    public Class<? extends AEntity> getEntityType() {
        return aEntityDefinition.getEntity().getClass();
    }
}