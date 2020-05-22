private boolean isComputerProducerAlreadyExist(ComputerProducer computerProducer){
    return this.getAllComputerProducers()
            .map((List<ComputerProducer> computerProducers) -> computerProducers.stream()
                    .anyMatch(producer -> producer.getProducerName().equalsIgnoreCase(computerProducer.getProducerName())))
            .orElse(Boolean.FALSE);
}