class ShareAnalyzer {

    private final int[] aktiePris;
    private int sellMinut = 0, buyMinut = 0, buyPrice,  sellPrice;

    ShareAnalyzer(int[] aktiePris) {

        this.aktiePris = aktiePris;
        findProfit();
    }

    private void findProfit() {

        if (aktiePris.length < 1) return ;
        int minValue = aktiePris[0];
        int maxValue = minValue;
        int indeksMaxMinut = 0, indeksMinMinut = 0;

        for (int i = 1; i < aktiePris.length; i++) {
            if (aktiePris[i] > maxValue) {
                maxValue = aktiePris[i];
                indeksMaxMinut = i;
                int priceDiff = maxValue - minValue;
                if (priceDiff > getProfit()) {
                    sellPrice = maxValue;
                    buyPrice  = minValue;
                    sellMinut = indeksMaxMinut;
                    buyMinut = indeksMinMinut;
                }
            } else if (aktiePris[i] < minValue) {
                minValue = maxValue = aktiePris[i];
                indeksMinMinut = i;
            }
        }
    }

    //time in minutes from opening
    int getSellTime() {return sellMinut;}

    int getSellPrice() {return sellPrice;}

    //time in minutes from opening
    int getBuyTime() {return buyMinut;  }

    int getBuyPrice() {return buyPrice;}

    int getProfit() {   return sellPrice - buyPrice;    }
}