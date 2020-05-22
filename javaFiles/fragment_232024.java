if (quantity< 10) {
    if (quantity >= 10 || quantity <= 19)
        rate = 0.20;
    else if (quantity >= 20 || quantity <=49)
        rate = 0.30;
    else if (quantity >= 50 || quantity <=99)
        rate = 0.40;
    else if (quantity > 100)  
        rate = 0.50;