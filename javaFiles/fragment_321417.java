List.metaClass.collectWithIndex = { yield ->
    def collected = []
    delegate.eachWithIndex { listItem, index ->
        collected << yield(listItem, index)
    }

    return collected 
}

result = list.collectWithIndex { it, index -> "${index + 1}. ${it}" }