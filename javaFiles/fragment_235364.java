BigDecimal sumContributionPercentage = 
    mandateDetails.stream()
                  .filter(m -> !(VERFI_STATUS_CLOSED.equals(m.getMandateVerificationStatusType().getCode()) || 
                                 VERFI_STATUS_REJECTED.equals(m.getMandateVerificationStatusType().getCode())))
                  .map(InstrumentMandateDetail::getContributionPercentage)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);