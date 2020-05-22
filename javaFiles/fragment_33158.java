if (result.getPurchasesList().size() > 0) {
    if (result
            .getPurchasesList()
            .get(0)
            .getSku()
            .equals(constant.sku_subscription_weekly)) {
        premium = 2;
    } else {
        // TODO: subscription expired
    }
} else {
    // TODO: subscription expired
}