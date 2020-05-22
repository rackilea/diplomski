int weightedBitCount(long word) {
       return (Long.bitCount(word & 0xFFFF_FFFF_0000_0000L) << 5)
            + (Long.bitCount(word & 0xFFFF_0000_FFFF_0000L) << 4)
            + (Long.bitCount(word & 0xFF00_FF00_FF00_FF00L) << 3)
            + (Long.bitCount(word & 0xF0F0_F0F0_F0F0_F0F0L) << 2)
            + (Long.bitCount(word & 0xCCCC_CCCC_CCCC_CCCCL) << 1)
            + (Long.bitCount(word & 0xAAAA_AAAA_AAAA_AAAAL) << 0);
}