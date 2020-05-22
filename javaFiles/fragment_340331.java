public void doActivity(DatabaseIdentifier dbID, ActivityIdentifier actID) {    
    synchronized( dbID.getLock(actID) ) { 
       // Do an action that can be guaranteed thread-safe per unique
       // combination of dbIT and actID, but needs to share a 
       // lock if they are both the same.
    }
}