public void initLib(String passcode) {
    final char[] PASS_ENCRYPTED  = "f5uhjgf56ik8kv214d5".toCharArray();
    final char[] PASS_MINUSMASK  = "bc".toCharArray();
    final int    PASS_SHIFT      = 11;
    final int    PASS_MASK_MINUS = 2;

    for (int ctr = 0; ctr < PASS_MINUSMASK.length; ++ctr) {  
        final char next = PASS_ENCRYPTED[PASS_SHIFT + ctr - PASS_MASK_MINUS];

        if (passcode.charAt(ctr) != next - (PASS_MINUSMASK[ctr] - 'a')) {
            // make the lib unusable by some inits. But it should look as a proper initialization
            return;
        }
    }    

    // make the lib usable by some inits.
}