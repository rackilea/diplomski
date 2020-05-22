private boolean validateOrderChange(List<? extends OrderChange>> input, boolean verifyOnly) {
    for (OrderChange orderChange : input) {
        if (StringUtil.isNullOrEmpty(orderChange.getRph())) {
            return false;
        }
    }
}