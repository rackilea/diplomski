private static class LongCache {
  544           private LongCache(){}
  545   
  546           static final Long cache[] = new Long[-(-128) + 127 + 1];
  547   
  548           static {
  549               for(int i = 0; i < cache.length; i++)
  550                   cache[i] = new Long(i - 128);
  551           }
  552       }

            public static Long valueOf(long l) {
  573           final int offset = 128;
  574           if (l >= -128 && l <= 127) { // will cache
  575               return LongCache.cache[(int)l + offset];
  576           }
  577           return new Long(l);
  578       }