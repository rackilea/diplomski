public Date getNextDay() throws Exception {
    if (monat == 2) {
        // wenn Februar 29 Tage hat.
        if (jahr % 4 == 0 || jahr % 400 == 0) {
            if (tag > 0 & tag < 29) {
                return new Date(tag + 1, monat, jahr);
            } else if (tag == 29 & monat == 2) {
                return new Date(tag - tag + 1, monat + 1, jahr);
            } else {
                throw new Exception("Im Februar können Sie nur bis 28 schreiben!");
            }
        }
        // wenn Februar 28 Tage hat.
        if (jahr % 4 != 0 || jahr % 100 != 0 && monat == 2) {
            if (tag > 0 & tag < 28) {
                return new Date(tag + 1, monat, jahr);
            } else if (tag == 28 & monat == 2) {
                return new Date(tag - tag + 1, monat + 1, jahr);
            } else {
                throw new Exception("Im Februar können Sie nur bis 28 schreiben!");
            }
        }
    } else if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
        if (tag <= 31 & monat <= 12 & jahr > 0) {
            if (tag < 31) {
                return new Date(tag + 1, monat, jahr);
            } else if (tag == 31 & monat < 12) {
                return new Date(tag - tag + 1, monat + 1, jahr);
            } else if (monat == 12) {
                if (tag == 31 & monat == 12) {
                    return new Date(tag - tag + 1, monat - monat + 1, jahr + 1);
                } else {
                    return new Date(tag, monat, jahr + 1);
                }
            }

        } else {
            throw new Exception("Sie haben ein ungültiges Datum eingegeben!");
        }

    } else if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
        if (tag <= 30 & monat <= 12 & jahr > 0) {
            if (tag < 30) {
                return new Date(tag + 1, monat, jahr);
            } else if (tag == 30 & monat < 12) {
                return new Date(tag - tag + 1, monat + 1, jahr);
            } else if (monat == 12) {
                if (tag == 31 & monat == 12) {
                    return new Date(tag - tag + 1, monat - monat + 1, jahr + 1);
                } else {
                    return new Date(tag, monat, jahr + 1);
                }
            }

        } else {
            throw new Exception("Sie haben ein ungültiges Datum eingegeben!");
        }

    }
    return null;
}