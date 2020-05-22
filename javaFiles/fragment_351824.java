public void setRelation(final User thatUser)
{
    final Relations that = thatUser.getRelations();

    synchronized(lockOrder < that.lockOrder ? this : that)
    {
        synchronized(lockOrder < that.lockOrder ? that : this)
        {
            storeRelation(thatUser);

            if(! that.hasRelation(user))
                that.storeRelation(user);
        }
    }
}