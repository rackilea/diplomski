from("snmp:0.0.0.0:1611?protocol=udp&type=TRAP")
            .process { exchange ->
                val message = exchange.getIn() as SnmpMessage
                exchange.out.body = CustomPduEvent(message.snmpMessage.requestID.toLong(), message.snmpMessage.type)
            }
            .bean(repository, "save")
            .process {
                logger.debug("MIH :: DB Entries [" + repository.findAll() + "]")
            }