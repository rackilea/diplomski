"select q.user, q.contact.parent.region, sum( case " +
        " when a.type = :type_surcharge and a.amountType = :amount_type_percentage then ( a.amount * qi.price ) " +
        " when a.type = :type_surcharge and a.amountType = :amount_type_amount then ( a.amount ) " +
        " when a.type = :type_discount and a.amountType = :amount_type_percentage then ( -1 * a.amount * qi.price ) " +
        " else ( -1 * a.amount ) end ) " +
        " from " + Quote.class.getName() + " q " +
        " left join q.quoteItems qi " +
        " left join qi.adjustments a " +
        " where q.date between :from and :to and q.contact.parent.region in :regions group by q.user, q.contact.parent.region";