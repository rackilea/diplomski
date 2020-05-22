System.out.println("Requested neighbors for element at row "+row+", col "+col+" "+"("+getElement(spot, row, col)+")");

System.out.print("North: "+ getElement(spot, row - 1, col));
System.out.print(" South: " + getElement(spot, row + 1, col));
System.out.print(" East: " + getElement(spot, row, col + 1));
System.out.print(" West: "+ getElement(spot, row, col - 1));