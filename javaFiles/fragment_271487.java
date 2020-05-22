public final class TransactionFeeEqualOrGreaterThanZeroValidationRule implements GlobalPricingRequestValidationManager.ValidationRule {

    @Override
    public void validate(List<GlobalPricingRequest> globalPricingRequests) {
        if (globalPricingRequests.stream()
                                 .map(GlobalPricingRequest::getFeePerTransact)
                                 .filter(Objects::nonNull)
                                 .anyMatch(val -> val.signum() == -1)))
            throw ExceptionHelper.badRequest("Fee Per Transaction can't be less than zero");
    }
}

public final class RevenueFeeEqualOrGreaterThanZeroValidationRule implements GlobalPricingRequestValidationManager.ValidationRule {

    @Override
    public void validate(List<GlobalPricingRequest> globalPricingRequests) {
        if (globalPricingRequests.stream()
                                 .map(GlobalPricingRequest::getEventTypePricingList)
                                 .flatMap(List::stream)
                                 .map(EventTypePricingMapping::getFeePerRevenue)
                                 .filter(Objects::nonNull)
                                 .anyMatch(val -> val.signum() == -1)))
            throw ExceptionHelper.badRequest("Fee Per Transaction can't be less than zero");

    }
}