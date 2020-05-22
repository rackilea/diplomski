Stripe.apiKey = "sk_test_XXX";

Map<String, Object> couponParams = new HashMap<String, Object>();
couponParams.put("percent_off", 25);
couponParams.put("duration", "repeating");
couponParams.put("duration_in_months", 3);
couponParams.put("id", "25OFF");

Coupon.create(couponParams);