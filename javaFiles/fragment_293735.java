public void syncDatabases()
{        
    // First get the changes of the two replication-partners
    Db4oEmbeddedReplicationProvider providerA = new Db4oEmbeddedReplicationProvider(hostContainer);
    Db4oEmbeddedReplicationProvider providerB = new Db4oEmbeddedReplicationProvider(clientContainer);
    ReplicationSession replication = Replication.begin(providerA, providerB);

    ObjectSet<Object> changesOnHost = replication.providerA().objectsChangedSinceLastReplication();
    ObjectSet<Object> changesOnClient = replication.providerB().objectsChangedSinceLastReplication();

    // then iterate over both change-sets and replicate it
    for (Object changedObjectOnClient : changesOnClient)
    {
        replication.replicate(changedObjectOnClient);
    }
    for (Object changedObjectOnHost : changesOnHost)
    {
        replication.replicate(changedObjectOnHost);
    }
    replication.commit();

    replication.replicateDeletions(Object.class);
}