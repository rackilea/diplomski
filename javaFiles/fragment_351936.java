// Prepare PCF command to inquire queue status (status type)
inquireQueueStatus = new PCFMessage(CMQCFC.MQCMD_INQUIRE_Q_STATUS);
inquireQueueStatus.addParameter(CMQC.MQCA_Q_NAME, "name of queue to inquire");
inquireQueueStatus.addParameter(CMQCFC.MQIACF_Q_STATUS_TYPE, CMQCFC.MQIACF_Q_STATUS);
inquireQueueStatus.addParameter(CMQCFC.MQIACF_Q_STATUS_ATTRS, new int[] {
                  CMQC.MQCA_Q_NAME, CMQC.MQIA_CURRENT_Q_DEPTH,
                  CMQCFC.MQCACF_LAST_GET_DATE, CMQCFC.MQCACF_LAST_GET_TIME,
                  CMQCFC.MQCACF_LAST_PUT_DATE, CMQCFC.MQCACF_LAST_PUT_TIME,
                  CMQCFC.MQIACF_OLDEST_MSG_AGE, CMQC.MQIA_OPEN_INPUT_COUNT,
                  CMQC.MQIA_OPEN_OUTPUT_COUNT, CMQCFC.MQIACF_UNCOMMITTED_MSGS });