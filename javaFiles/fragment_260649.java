private static final List<String> APPROVED_LENGTH;
private static final List<String> KM_APPROVED_LIST;
private static final List<String> LM_APPROVED_LIST;

static {
    KM_APPROVED_LIST = new ArrayList<String>();
    KM_APPROVED_LIST.add("L");
    KM_APPROVED_LIST.add("G");
    LM_APPROVED_LIST = new ArrayList<String>();
    LM_APPROVED_LIST.add("P");
    LM_APPROVED_LIST.add("K");
    APPROVED_LENGTH = new ArrayList<String>();
    APPROVED_LENGTH.addAll(KM_APPROVED_LIST);
    APPROVED_LENGTH.addAll(LM_APPROVED_LIST);
}