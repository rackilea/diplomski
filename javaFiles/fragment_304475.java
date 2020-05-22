class WeakAssociation { }
class StrongAssociation { }
class NeedWeekAndStrongAssociation {
    private WeakAssociation weakAssociation;
    private StrongAssociation strongAssociation;
    public NeedWeekAndStrongAssociation(StrongAssociation strongAssociation) {
        this.strongAssociation = strongAssociation;
    }
    public void setWeakAssociation(WeakAssociation weakAssociation) {
        this.weakAssociation = weakAssociation;
    }
}