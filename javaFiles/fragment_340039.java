bool hasElement = false;
for(int i = 0; !hasElement && i < schedules.size(); i++) {
    if(schedules[i].IsStillRelevantOn(calculatedDate))
        hasElement = true;
}

if (!hasElement) {
    // sequence is empty
}