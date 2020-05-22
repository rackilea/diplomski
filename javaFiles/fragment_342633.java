case 0: {
        System.out.print("Insert the N: ");
        double N = in.nextDouble();
        double mol = N / Na;
        System.out.print("There are " + mol + " mol in that sample");
        break; 
    }

    case 1: {
        System.out.print("Insert the m: ");
        double m = in.nextDouble();
        System.out.print("Insert the M: ");
        double M = in.nextDouble();
        double mol = m / M;
        System.out.print("There are " + mol + " mol in that sample");
        break;
    }