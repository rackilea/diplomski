static class Range {
    public final int start;
    public final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

static final Map<Integer,Range> RANGE_MAP = new HashMap<Integer,Range>();
static {
    RANGE_MAP.put(21, new Range(9,19));
    RANGE_MAP.put(20, new Range(12,18));
    // ...
}

void calling_method() {
    for(Entry<Integer,Range> entry : RANGE_MAP.entrySet()) {
        int ii = entry.getKey();
        Range r = entry.getValue();
        for(int xx = r.start; xx <= r.end; xx++){
            method(ii,xx);
        }
    }
}

void method(int ii, int xx) {
    // do stuff
}