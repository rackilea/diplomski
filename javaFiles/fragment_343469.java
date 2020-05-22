taxrate = 0;
    income = scan.nextDouble();
    if(income <= 6000){
        taxrate = .10;
    }

    if(income >= 6001 && income <= 27950 ){
        taxrate = .15;
    }

    if(income >= 27951 && income <= 67700){
        taxrate = .27;
    }

    if(income >= 67701 && income <= 141250){
        taxrate = .30;
    }

    if(income >= 141251 && income <= 307050){
        taxrate = .35;
    }

    if(income >= 307051){
        taxrate = .386;
    }
    return income * taxrate;