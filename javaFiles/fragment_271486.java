public final class GlobalPricingRequestValidationManager {

    private final List<ValidationRule> validationRules =
            Arrays.asList(
                new TransactionFeeEqualOrGreaterThanZeroValidationRule(),
                new RevenueFeeEqualOrGreaterThanZeroValidationRule());

    public void validate(List<GlobalPricingRequest> globalPricingRequests) {
        validationRules.forEach(validationRule -> validationRule.validate(globalPricingRequests));
    }

    public interface ValidationRule {

        void validate(List<GlobalPricingRequest> globalPricingRequests);
    }

}