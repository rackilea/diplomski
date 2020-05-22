enum Status {
    FAILED(0, 'Failed'), 
    SUCCESSFUL(1, 'Successful')

    private final int key
    private final String val

    public Status(int key, String val) {
        this.val = val
        this.key = key
    }

    String toString() { val }

    static boolean containsVal(String val) {
        Status.values()*.val.contains val
    }
}

assert Status.containsVal('Failed')