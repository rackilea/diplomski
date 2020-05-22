int j = 0;
for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
        String BalColumn = c.getString(c
                .getColumnIndex("debt_total"));
        String AprColumn = c.getString(c.getColumnIndex("apr"));
        double aprColumn = Double.valueOf(BalColumn);
        double balColumn = Double.valueOf(AprColumn);

        SingleAprRate = (((aprColumn / 100) / 12) * balColumn);
        storeFees[j++] = SingleAprRate; 

    }