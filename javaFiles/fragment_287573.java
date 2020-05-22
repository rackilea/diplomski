BigDecimal totalWeight = cartItems.stream()
        .filter(cart -> cart != null
                && cart.getProduct() != null 
                && cart.getProduct().getWeight() != null)
        .map(cart -> cart.getProduct().getWeight().multiply(BigDecimal.valueOf(cart.getQty())))
        .reduce(BigDecimal.ZERO, BigDecimal::add)
        .setScale(SCALE, RoundingMode.HALF_UP);