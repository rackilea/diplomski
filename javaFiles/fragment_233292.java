String ch = "";
    for (int row = 0; row < listStock.size(); row++) {

        final StockVo stock = listStock.get(row);

        // Vue Mensuel
        if (isMois) {               
            //for (int i = moisD; i < taillePeriode + moisD; i++) {
                final int mois = (row % 12) + 1;
                final int annee = row / 12;

                    if (mois <= 9) {

                        ch = "0" + mois + "/" + (anneeD + annee);

                    } else  {
                        ch = mois + "/" + (anneeD + annee);
                    }

                sheet.addCell(new Label(3 + row, 6, ch, arial10format));