PromoDebit promoDebit = new PromoDebit();
        promoDebit.promoCode=promoCode;
        promoDebit.userId=userId;
        promoDebit.countUsages=countUsages;
        promoDebit.endDate=endDate;
        promoDebit.startDate=startDate;
        promoDebit.status=1;
        promoDebit.calcValue=Float.parseFloat(p.getProperty("promoPercent"));