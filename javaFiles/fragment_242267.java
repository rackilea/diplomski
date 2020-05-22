// note: recurrence expansion takes place in a specific time zone
TimeZone tz = TimeZone.getDefault();
// the start of the recurring event
DateTime start = new DateTime(tz, 2017, 5 - 1 /* zero based */, 23, 12, 0, 0);

// parse the RRULE
RecurrenceRule recurrenceRule = new RecurrenceRule("FREQ=YEARLY;BYMONTHDAY=23;BYMONTH=5;COUNT=30");
// parse the EXRULE (in this case every 3rd instance of the RRULE)
RecurrenceRule exceptionRule = new RecurrenceRule("FREQ=YEARLY;INTERVAL=3;BYMONTHDAY=23;BYMONTH=5;COUNT=10");

// create an empty RecurrenceSet
// a recurrence set is the set of all actual instance of a recurring event and may consist of multiple instance and excludes sources 
RecurrenceSet recurrenceSet = new RecurrenceSet();
// add the instances of the RRULE
recurrenceSet.addInstances(new RecurrenceRuleAdapter(recurrenceRule));
// exclude the instances of the EXRULE
recurrenceSet.addExceptions(new RecurrenceRuleAdapter(exceptionRule));

RecurrenceSetIterator recurrenceSetIterator = recurrenceSet.iterator(start.getTimeZone(), start.getTimestamp());

int maxInstances = 10; // limit instances for rules that recur forever
// iterate as long as the recurrence set still has instances
while (recurrenceSetIterator.hasNext() && (!recurrenceRule.isInfinite() || maxInstances-- > 0))
{
    // get the next instance of the recurrence set
    DateTime nextInstance = new DateTime(start.getTimeZone(), recurrenceSetIterator.next());
    // do something with nextInstance
    System.out.println(nextInstance);
}