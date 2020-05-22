//Connect to AlarmIRP
AlarmIRP alarmIRP = AlarmIRPHelper.narrow(orb.string_to_object(alarmIrpIOR.value));
StringTypeOpt alarmFilter = new StringTypeOpt();
alarmFilter.value("");
DNTypeOpt base_object = new DNTypeOpt();
base_object.value("");
BooleanHolder flag = new BooleanHolder(false);  // false for iteration
AlarmInformationIteratorHolder iter = new AlarmInformationIteratorHolder();

List<String> alarmIds = get_alarm_list(alarmIRP, alarmFilter, base_object, flag, iter);

private List<String> get_alarm_list(org._3gppsa5_2.AlarmIRPSystem.AlarmIRP alarmIRP, org._3gppsa5_2.ManagedGenericIRPConstDefs.StringTypeOpt alarmFilter, org._3gppsa5_2.AlarmIRPConstDefs.DNTypeOpt base_object, BooleanHolder flag, org._3gppsa5_2.AlarmIRPSystem.AlarmInformationIteratorHolder iter) throws org._3gppsa5_2.AlarmIRPSystem.GetAlarmList, org._3gppsa5_2.ManagedGenericIRPSystem.ParameterNotSupported, org._3gppsa5_2.AlarmIRPSystem.NextAlarmInformations, org._3gppsa5_2.ManagedGenericIRPSystem.InvalidParameter, BAD_OPERATION {
    logger.info("[get-alarm-list][start]");
    alarmIRP.get_alarm_list(alarmFilter, base_object, flag, iter);

    List<StructuredEvent> alarms = new ArrayList();
    EventBatchHolder alarmInformation = new EventBatchHolder();
    short alarmSize = 100;
    List<String> alarmIds = new ArrayList();
    while (iter.value.next_alarmInformations(alarmSize, alarmInformation)) {
        alarms.addAll(Arrays.asList(alarmInformation.value));
        logger.info("Current alarm size:" + alarms.size());
    }

    for (StructuredEvent event : alarms) {
        try {
        //printAlarm(event);
        } catch (Exception ex) {
        }
        List<Property> rem = new ArrayList<Property>();
        rem.addAll(Arrays.asList(PropertySeqHelper.extract(event.remainder_of_body)));
        for (Property property : rem) {
        if (!property.name.equals(org._3gppsa5_2.AlarmIRPNotifications.NotifyNewAlarm.ALARM_ID)) {
            continue;
        }

        alarmIds.add(property.value.extract_string());
        }
    }
    logger.info("[get-alarm-list][completed] size :" + alarms.size());

    return alarmIds;
}