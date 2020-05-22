{
    responseHeader={
        status=0,
        QTime=1650
    },
    cluster={
        collections={
            collection1={
                shards={
                    shard1={
                        range=80000000-ffffffff,
                        state=active,
                        replicas={
                            core_node2={
                                state=active,
                                core=collection1_shard1_replica1,
                                node_name=192.112.21.21: 8983_solr,
                                base_url=http: //192.112.21.21: 8983/solr,
                                leader=true
                            }
                        }
                    },
                    shard2={
                        range=0-7fffffff,
                        state=active,
                        replicas={
                            core_node1={
                                state=active,
                                core=collection1_shard2_replica1,
                                node_name=192.112.21.21: 8984_solr,
                                base_url=http: //192.112.21.21: 8984/solr,
                                leader=true
                            }
                        }
                    }
                },
                maxShardsPerNode=1,
                router={
                    name=compositeId
                },
                replicationFactor=1,
                autoAddReplicas=false,
                autoCreated=true
            }
        },
        live_nodes=[
            192.112.21.21: 8983_solr,
            192.112.21.21: 8984_solr
        ]
    } }