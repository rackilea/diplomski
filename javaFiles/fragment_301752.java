// Converting Object[][] to List<IdName>
List<IdName> list = 
      Arrays.stream(dbResult)
            .collect(
                collectingAndThen(
                    groupingBy(this::extractIdName,
                        collectingAndThen(
                            groupingBy(this::extractAnother,
                                mapping(this::extractFormat, toList())),
                            this::setFormats
                        )),                                                             
                    this::setAnothers));