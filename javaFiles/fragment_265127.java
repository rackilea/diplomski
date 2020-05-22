public final void setState(EntityState state)
{
    if(this.state == state)
        Gdx.app.error(this.getClass().getSimpleName(), "the state was allready " + state);
    else
    {
        this.state = state;
        switch(state)
        {
            case CREATED:       notifyCreation(this);       break;
            case GENERATED:     notifyGeneration(this);     break;
            case TO_BE_REMOVED: notifyFlagForRemoval(this); break;
            case INACTIVE:      notifyDestruction(this);    break;
            default : Gdx.app.error(this.getClass().getSimpleName(), "entity state became " + state);
        }
    }
}