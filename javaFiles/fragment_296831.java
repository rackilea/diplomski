private static long getBits(long l){
        if(l == 0){
            return 0;
        }else if(l == 1){
            return 1;
        }
        boolean isPowerOf2Minus1 = (l & (l+1)) == 0;
        long maxBitNum = Long.highestOneBit(isPowerOf2Minus1 ? l+1 : l);
        int maxBit = Long.numberOfTrailingZeros(maxBitNum);
        if((l & (l+1)) == 0){
            return maxBit * (maxBitNum >> 1);
        }
        long diff = l - maxBitNum;
        return diff + 1 + getBits(maxBitNum - 1) + getBits(diff);
    }