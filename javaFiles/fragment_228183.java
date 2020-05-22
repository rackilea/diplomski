ScrollableResults results = query.scroll(ScrollMode.FORWARD_ONLY);

Timestamp ts = null;
while (results.next()) {
    ...
    //I need to extact a timestamp from the last record here
    ts = results.getTimestamp("timestamp_column");
}

// you'll have here ts with the value of the latest row.
// Be careful, it can be null in case of empty result set.