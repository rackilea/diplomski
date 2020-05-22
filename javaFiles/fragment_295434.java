if(cellValue.equals("sh")){
    System.out.print(cellValue + "\n");
    System.out.println(" cellColor 0: " + cellColor.getRgb()[0]);
    System.out.println(" cellColor 1: " + cellColor.getRgb()[1]);
    System.out.println(" cellColor 2: " + cellColor.getRgb()[2]);
    System.out.println(" cellColor 3: " + cellColor.getRgb()[3]);
    String hex = String.format("#%02x%02x%02x%02x", cellColor.getRgb()[0],cellColor.getRgb()[1], cellColor.getRgb()[2],cellColor.getRgb()[3]);
    System.out.println(hex.toUpperCase());
}