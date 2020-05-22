if (assertion.getConditions().getNotBefore() != null && assertion.getConditions().getNotBefore().isAfterNow()) {
    throw new ValidationException("Condition states that assertion is not yet valid (is the server time correct?)");
}

if (assertion.getConditions().getNotOnOrAfter() != null
                && (assertion.getConditions().getNotOnOrAfter().isBeforeNow() || assertion.getConditions().getNotOnOrAfter().isEqualNow())) {
    throw new ValidationException("Condition states that assertion is no longer valid (is the server time correct?)");
}