/**
    * This array is a lookup table that translates 6-bit positive integer
    * index values into their "Alternate Base64 Alphabet" equivalents.
    * This is NOT the real Base64 Alphabet as per in Table 1 of RFC 2045.
    * This alternate alphabet does not use the capital letters.  It is
    * designed for use in environments where "case folding" occurs.
    */
   private static final char intToAltBase64[] = {
       '!', '"', '#', '$', '%', '&', '\'', '(', ')', ',', '-', '.', ':',
       ';', '<', '>', '@', '[', ']', '^',  '`', '_', '{', '|', '}', '~',
       'a', 'b', 'c', 'd', 'e', 'f', 'g',  'h', 'i', 'j', 'k', 'l', 'm',
       'n', 'o', 'p', 'q', 'r', 's', 't',  'u', 'v', 'w', 'x', 'y', 'z',
       '0', '1', '2', '3', '4', '5', '6',  '7', '8', '9', '+', '?'
   };