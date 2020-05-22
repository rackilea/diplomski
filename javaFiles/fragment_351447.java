list1.each { l1 ->
    l1.each { subL1 ->
        list2.each { l2 ->
            if (subL1.toString() == l2.toString()) {
                // match found
                println "match found"
            }
        }
    }
}