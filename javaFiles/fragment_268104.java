ipAddressRequestCount.foreachRDD { rdd => rdd.foreachPartition { partition =>
    // Open connection to storage system (e.g. a database connection)
    partition.foreach { item =>
    // Use connection to push item to system
    }
    // Close connection
    } 
}