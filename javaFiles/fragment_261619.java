public String woordBepalen(String teBepalenWoordVanCat) {
        for (int p = 0; p < CATEGORIES; p++) {
           if (TERADENWOORDEN[p][0].equals(teBepalenWoordVanCat))
             return TERADENWOORDEN[p][1];
        }
        return null;
 }