Optional<String> desc = Optional.ofNullable(objParam)
        .map(MyObject::getMyParentObject)
        .map(MyObject::getListOfMyObjects)
        .map(List::stream)
        .flatMap(Stream::findFirst)
        .map(MyObject::getDesc);