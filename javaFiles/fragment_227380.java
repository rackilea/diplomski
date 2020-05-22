Map<Date, List<Integer>> result =
this.ctx.select(
    ...
)
.from(SHOP_OFFER).join(...)
.fetchGroups(SHOP_OFFER.DATE_COLUMN, SHOP_OFFER.ID);