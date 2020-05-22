private static boolean isError(int charge) {
    int random = new Random().nextInt(10);
    switch (charge) {
        case 1:  return random >= 10;
        case 2:  return random >= 9;
        case 3:  return random >= 8;
        case 4:  return random >= 7;
        case 5:  return random >= 6;
        case 6:  return random >= 5;
        case 7:  return random >= 4;
        case 8:  return random >= 3;
        case 9:  return random >= 2;
        case 10: return random >= 1;
        default: return false;
    }
}