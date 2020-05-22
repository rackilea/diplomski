List<Obligation> obligationList = ...;
List<ObligationStatus> statusList = ...;

// For better performance, make a map
Map<String, ObligationStatus> statusMap = new HashMap<>(statusList.size());
for (ObligationStatus status : statusList)
    statusMap.put(status.getTopic(), status);

// Assign status values
for (Obligation obligation : obligationList) {
    ObligationStatus status = statusMap.get(obligation.getTopic());
    if (status != null) {
        ob.setStatus(status.getStatus());
        ob.setComment(status.getComment());
    }
}