MQQueue outQ = qMgr.accessQueue(qName,
                                openOptions,
                                null,           // default q manager
                                null,           // no dynamic q name
                                null);          // no alternate user id

int inCount = outQ.getOpenInputCount();