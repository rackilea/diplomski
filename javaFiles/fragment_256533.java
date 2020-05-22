import java.util.*;
    //...

    BitSet bs = new BitSet();
    int[] onBits = new int[] { 1,2,4,5,6,7,11,13,21,22,23,24,25 };
    for (int onBit : onBits) {
        bs.set(onBit);
    }
    System.out.println(bs);
    // {1, 2, 4, 5, 6, 7, 11, 13, 21, 22, 23, 24, 25}

    StringBuilder sb = new StringBuilder();
    for (int begin, end = -1; (begin = bs.nextSetBit(end + 1)) != -1; ) {
        end = bs.nextClearBit(begin) - 1;
        if (sb.length() > 0) sb.append(", ");
        sb.append(
            (begin == end)
                ? String.format("+%d", begin)
                : String.format("+%d/%d", begin, end)
        );
    }
    System.out.println(sb);
    // +1/2, +4/7, +11, +13, +21/25