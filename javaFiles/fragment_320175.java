Result<Record> result = create
  .select(field("(select nr_zew from bo_get_sip_cti_polaczenie_info(uuid))").as("nr_zew"))
  .distinctOn(field("uuid"))
  .from("bo_sip_cti_event_day")
  .where("data_ins::date = current_date")
  .and("kierunek like 'P'")
  .and("(hangup_cause like 'NO_ANSWER' or hangup_cause like 'NO_USER_RESPONSE') ")
  .fetch();