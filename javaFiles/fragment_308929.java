TextArea ta = new TextArea();
ta.scrollTopProperty().addListener((obs, oldVal, newVal) -> 
    System.out.println("Position from top: " + newVal);

ta.scrollLeftProperty().addListener((obs, oldVal, newVal) -> 
    System.out.println("Position from left: " + newVal));