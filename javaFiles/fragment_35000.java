service {
    paxos-single-replica-limit 1 # Number of nodes where the replica count is automatically reduced to 1.
    proto-fd-max 15000
    batch-index-threads 2 # you don't need 24 batch threads, you're not using them
    query-threads 24 # setting it to #cpu
    query-in-transaction-thread true # because you query an in-memory namespace
    query-priority 40
    # auto-pin cpu # uncomment this if you have kernel >= 3.19
}

logging {
    console {
        context any info
    }
}

network {
    service {
        address any
        port 3000
    }

    heartbeat {
        mode multicast
        multicast-group 239.1.99.222
        port 9918

        # To use unicast-mesh heartbeats, remove the 3 lines above, and see
        # aerospike_mesh.conf for alternative.

        interval 150
        timeout 10
    }

    fabric {
        port 3001
    }

    info {
        port 3003
    }
}

namespace demo {
    replication-factor 2
    memory-size 10G
    partition-tree-sprigs 4096 # maximize these for in-memory, you have plenty of DRAM
    default-ttl 30d

    storage-engine memory
}