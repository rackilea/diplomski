if (userinput == 1 && computerinput == 1 && cardLimiter == 0) {
        System.out.println("you have played the emperor! \n the emperor is defeated by the slave");
            cardLimiter++;
    } else if ((userinput == 1 && computerinput == 1 && cardLimiter == 1)) {
                System.out.println("you cannot play the emperor this turn \n you have played the citizen instead");
        }