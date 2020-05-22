public int hashCode() {
        int re=0;
        for (byte temp : encode)
            re += encode[temp]*encode[temp]*encode[temp];
        return re;
    }