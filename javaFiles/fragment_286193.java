ArrayList<VitalReportsDetails> details = new ArrayList<>();
for(VitalReportsDetails detail : hm.get("Weight")) {
    if(!detail.getValue().equals("0")) { details.add(detail); }
}

int min, max;
if(details.isEmpty()) {
    // No data => default values
    min = 0;
    max = 0;
} else {
    min = Integer.parseInt(Collections.min(details, new VitalCompare()).getValue());
    max = Integer.parseInt(Collections.max(details, new VitalCompare()).getValue());
}