/** Lookup table: character for a half-byte */
    static final char[] CHAR_FOR_BYTE = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
         /** Encode byte data as a hex string... hex chars are UPPERCASE*/
         public static String encode(byte[] data){
             if(data == null || data.length==0){
                 return "";
             }
             char[] store = new char[data.length*2];
             for(int i=0; i<data.length; i++){
                 final int val = (data[i]&0xFF);
                 final int charLoc=i<<1;
                 store[charLoc]=CHAR_FOR_BYTE[val>>>4];
                 store[charLoc+1]=CHAR_FOR_BYTE[val&0x0F];
             }
             return new String(store);
         }