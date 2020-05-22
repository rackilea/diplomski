public class DataHolder{

        private String StockItems;
        private int isSelected;

        public DataHolder(String StockItems, int isSelected) {
            this.StockItems = StockItems;
            this.isSelected = isSelected;

        }

        public String getStockItems() {
            return StockItems;
        }

        public void setStockItems(String StockItems) {
            this.StockItems = StockItems;
        }

        public int getiIsSelected() {
            return isSelected;
        }

        public void setIsSelected(String isSelected) {
            this.isSelected = isSelected;
        }
    }