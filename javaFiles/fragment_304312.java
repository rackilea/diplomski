Part[] part = new Part[6];
part[0] = new Part("p101", "Crank", 218, 12.20);
part[1] = new Part("p102", "Pedal", 320, 14.30);
part[2] = new Part("p103", "Handlebar", 120, 35.50);
part[3] = new Part("p104", "Stem", 90, 20.00);
part[4] = new AssembledPart("p183", "Crank-Pedal", 80, 3.50, part[0], part[1]);
part[5] = new AssembledPart("p184", "Handlebar-Stem", 30, 1.50, part[2], part[3]);