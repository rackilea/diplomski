// Prepare PCF command to reset queue statistics
queueResetStats = new PCFMessage(CMQCFC.MQCMD_RESET_Q_STATS);
queueResetStats.addParameter(CMQC.MQCA_Q_NAME, queueName);

pcfResp3 = pcfAgent.send(queueResetStats);

queueMsgDeqCount = pcfResp3[0].getIntParameterValue(CMQC.MQIA_MSG_DEQ_COUNT);
queueMsgEnqCount = pcfResp3[0].getIntParameterValue(CMQC.MQIA_MSG_ENQ_COUNT);