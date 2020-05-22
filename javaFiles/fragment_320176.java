Result<Record> result = create
  .select(field(
     select(BO_GET_SIP_CTI_POLACZENIE_INFO.NR_ZEW)
    .from(BO_GET_SIP_CTI_POLACZENIE_INFO.call(BO_SIP_CTI_EVENT_DAY.UUID))).as("nr_zew"))
  .distinctOn(BO_SIP_CTI_EVENT_DAY.UUID)
  .from(BO_SIP_CTI_EVENT_DAY)
  .where(BO_SIP_CTI_EVENT_DAY.cast(Date.class).eq(currentDate()))
  .and(BO_SIP_CTI_EVENT_DAY.KIERUNEK.like("P"))
  .and(BO_SIP_CTI_EVENT_DAY.HANGUP_CAUSE.like("NO_ANSWER")
    .or(BO_SIP_CTI_EVENT_DAY.HANGUP_CAUSE.like("NO_USER_RESPONSE")))
  .fetch();