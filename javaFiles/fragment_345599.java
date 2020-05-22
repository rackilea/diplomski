public class Product {
    String productDescription;
    String productCode;
    Double productPrice;
    //dummy properties
    Double productQuantity;
    Double productTotalAmount;
..
    @Override
        public Class getColumnClass(int column) {// returns a class representing the datatype of the data stored in that column
       switch (column) {
           case PRODUCT_DESCRIPTION_INDEX:
           case PRODUCT_CODE_INDEX:
              return String.class;
           case PRODUCT_QUANTITY_INDEX:
           case PRODUCT_PRICE_INDEX:
           case PRODUCT_TOTAL_AMOUNT_INDEX:
               return Double.class;
           default:
              return Object.class;
       }
    }
...