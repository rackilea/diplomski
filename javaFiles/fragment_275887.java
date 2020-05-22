public static void main(String[] args) {

    int[] stock_t = { 13, 5, 2, 12, 3, 15 };
    Stock s = new Stock();              //create Stock object
    int fi = s.maxProfit(stock_t);      //calculations will update days attribute
    System.out.println(s.getDays());    //get days according to last calculation
}