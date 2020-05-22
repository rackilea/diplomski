producer.send(new ProducerRecord<String, String>(topic, Messages.MSG_4K), new Callback() {
        public void onCompletion(RecordMetadata metadata, Exception e) {
            if (e != null)
                e.printStackTrace();
        }
});