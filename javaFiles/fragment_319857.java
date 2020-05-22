DateTime getChangedDoseEndDate(final DateTime actualTerminateDate, final DateTime discontinueDate) {
  if (actualTerminateDate != null && actualTerminateDate.isBefore(discontinueDate)) {
    return actualTerminateDate;
  }
  return discontinueDate;
}