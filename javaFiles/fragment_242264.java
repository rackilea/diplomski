data = Arrays.stream(data).       // Create stream from your array
    collect(Collectors.toMap(     // Transform it to Map
        d -> d.rawMaterialId,     // It is keys of creating map
        d -> d,                   // This is values of creating map 
        (d1, d2) -> {             // Function for merging values with same keys. 
                                  // There happens all neded concatenations.
            d1.location = d1.location + "," + d2.location;
            d1.batchNo = d1.batchNo + "," + d2.batchNo;
            d1.quantity = d1.quantity + "," + d2.quantity;
            return d1;
        }).
    values().toArray(new Data[0]); // Transform map to new array. 
                                   // Replace Data to real type of your items.