Criteria criteria = new Criteria();
        criteria = criteria.and("siteCode").is(siteCode);
        if (paymentMode != null) {
            criteria = criteria.and("paymentMode").is(paymentMode);
        }
        if (planCode != null) {
            criteria = criteria.and("packageCode").is(planCode);
        }
        if (status) {
            criteria = criteria.and("expiryDateTime").gt(new Date());
        } else {
            criteria = criteria.and("expiryDateTime").lte(new Date());
        }
        Query query = new Query(criteria);