@Override
public boolean supportsSequences() {
    return true;
}

@Override
public String getQuerySequencesString() {
    return "select seqname from sysibm.syssequences";
}