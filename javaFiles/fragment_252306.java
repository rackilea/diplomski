long[] l = messages.stream().mapToLong(Message::getOffset).toArray();
Arrays.sort(l);
for(int ix=1; ix<l.length; ix++) {
    long value = l[ix], expected = l[ix-1]+1;
    if(value!=expected)
        LOG.error("Missing offset(s) found in messages: missing from {} to {}",
                  expected, value);
}