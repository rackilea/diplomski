try {
    t[0] = new Triangle(6, 6, 6);
}
catch(IllegalValuesException e1) {
    System.out.println(e1.getMessage());

} 

try {
    t[1] = new Triangle(1, 4, 1);
}
catch(IllegalValuesException e1) {
    System.out.println(e1.getMessage());

}

try {
    t[2] = new Triangle(4, 4, 4);
}
catch(IllegalValuesException e1) {
    System.out.println(e1.getMessage());

}