// produce ordered stream
insert rstream into ArrivalTimeOrderedStream
select rstream * from MyTimestampedEvent.ext:time_order(arrival_time, 10 sec);

// aggregate
select first(xxx), last(xxx), ... from ArrivalTimeOrderedStream
.groupwin(customerId).length_batch(2) group by customerid