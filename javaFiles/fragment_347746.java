import static org.jooq.impl.DSL.*;

// And then
sum(
  decode()
  .when(VCG.VID.in(
      select(GRVAS.VID)
      .from(GRVAS)
        .join(GPRS).on(GPRS.ID.eq(GRVAS.GRID))
      .where(GPRS.ID.eq(G.ID))
      .and(GRVAS.STDATE.lt(Date.valueOf("2011-08-15")))
      .and(GRVAS.ENDDATE.gt(Date.valueOf("2011-09-14")))
  )), VCG.AMOUNT)
).as("allow")