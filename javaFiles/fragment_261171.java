List<String> packetsList = single.stream()
    .map(x -> x.replaceAll(".*packetsLost=(\\d+).*", "$1"))
    .collect(Collectors.toList());

List<String> timestampsList = single.stream()
    .map(x -> x.replaceAll(".* timestamp=([^}]+).*", "$1"))
    .collect(Collectors.toList());