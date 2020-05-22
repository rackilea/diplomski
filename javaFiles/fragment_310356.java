//inside of FileAnalysisActor
else if (message instanceof LineProcessingResult) {
    HashMap<String,Long>  localCount = ((LineProcessingResult) message).getIpAddressCount();

    localCount.foreach((ipAddress, count) -> {
        ipMap.put(ipAddress, ipMap.getOrDefault(ipAddress, 0L) + count);
    })