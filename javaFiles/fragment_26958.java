Optional<String> desc = Optional.ofNullable(objParam)
        .map(MyObject::getMyParentObject)
        .map(MyObject::getListOfMyObjects)
        .filter(lst -> ! lst.isEmpty())
        .map(lst -> lst.get(0))
        .map(MyObject::getDesc);