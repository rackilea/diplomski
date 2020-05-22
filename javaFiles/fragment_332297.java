TreeMap<Integer, Integer> languageCodePoints = new TreeMap<>();
languageCodePoints.put(0x0020, 0x007E);
languageCodePoints.put(0x00A0, 0x00FF);
languageCodePoints.put(0x0100, 0x017F);
languageCodePoints.put(0x0900, 0x097F); // Devanagri  

// So on for all other languages, referred ISO/IEC 10646:2010 
// for code points of present languages