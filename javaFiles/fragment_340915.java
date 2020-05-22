public static Encoder getEncoder(String encodingName) {
     for (CodecSet cp : codecSetLoader) {
         Encoder enc = cp.getEncoder(encodingName);
         if (enc != null)
             return enc;
     }
     return null;  
}