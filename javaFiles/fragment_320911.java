GameSettings.StartLogic();

    if (src.GameSettings.Classes().equals("mage")) {
        System.out.println("mage"); 
    }
    else if (src.GameSettings.Classes().equals("warrior")) {
        System.out.println("warrior");  
    }
    else if (src.GameSettings.Classes().equals("archer")) {
        System.out.println("archer");   
    }
    else {
        System.out.println("Non valid");

    }