String[] arrQty = { "2", "3", "10" };
String[] arrItemCode = { "Item 1", "Item 2", "Item 3" };
String[] arrAmount = { "100", "200", "80" };

if (arrQty.length != arrItemCode.length || arrQty.length != arrAmount.length) {
    throw new IllegalStateException("All arrays must have the same length." 
                                  + "arrQty[" + arrQty.length 
                                  + "], arritemCode[" + arrItemCode.length 
                                  + "], arrAmount[" + arrAmount.length + "]");
}