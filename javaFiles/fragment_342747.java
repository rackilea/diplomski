val gasLineItem = Customer(
            id = null,
            name = "name",
            publicationName = "",
            startDate = "2018-12-01",
            endDate = "2019-02-01"

    ).apply {
        items = mutableSetOf(
                gasCreative1,
                gasCreative2
        )
    }