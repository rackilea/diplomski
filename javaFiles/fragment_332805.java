Optional.ofNullable(request)
    .map(Request::getBody)
    .map(Body::getSections)
    .map(List::stream)
    .orElse(Stream.empty())
    .filter(section -> "name".equals(section.getName))
    .findFirst();