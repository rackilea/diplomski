Deckungen deck = DECKUNGEN.as("deck");
Deckungspraemien dpr = DECKUNGSPRAEMIEN.as("dpr");
Textbausteine txb = TEXTBAUSTEINE.as("txb");
Druckparameter dp = DRUCKPARAMETER.as("dp");

Table<?> dp1 = table(
    select(dp.DP_ID, dp.DP_WERT)
   .from(txb, dp)
   .where(dp.DP_TXB_ID.eq(txb.TXB_ID))
).as("dp1");

Record2<BigDecimal, BigDecimal> result =
using(configuration)
  .select(
     sum(dpr.DPR_BRUTTOPRAEMIE_PRT.plus(dpr.DPR_SOFORTRABATT_PRT)),
     max(field("to_number({0})", BigDecimal.class, dp1.field(dp.DP_WERT))))
  .from(deck, dpr, dp1)
  .where(dp1.field(dp.DP_ID).eq(druckparameterId))
  .fetchOne();