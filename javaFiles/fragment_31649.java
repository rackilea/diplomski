private final static class RequestConvertor 
        implements Function<CoreData, List<Request>> {
    @Override
    public List<Request> apply(CoreData coreData) {
        return RequestConvertorEnum.valueOf(coreData.getType())
                .convertToRequests(coreData);
    }
}