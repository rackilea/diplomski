val itemsCount = (list1 + list2)          // concat lists
    .groupBy { it.name }                  // group items by name
    .values                               // take list of values
    .map {                                // for each list
        it.reduce {                       // accumulate counts
            acc, item -> Item(item.name, acc.count + item.count)
        }
    }