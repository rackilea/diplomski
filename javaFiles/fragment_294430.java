kafkaConsumer.subscribe(topicNameList , new HandleRebalance())
            String kafkaMessages = null
            try{
                while(true){
                   ConsumerRecords kafkaRecords
                   kafkaRecords = kafkaConsumer.poll(100)
                     for(ConsumerRecord record: kafkaRecords){
                       partition = record.partition()
                       offset = record.offset()
                       topicName = record.topic()
                         Object message = record.value()
                       }