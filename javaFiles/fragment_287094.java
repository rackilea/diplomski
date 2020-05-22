v.vibrate(legit, 0);
// vibrate() combines both legit[0] + legit[2] for the 'off' time

long tooLegit = new long[100];
tooLegit[0] = 1000;
tooLegit[1] = 500;
tooLegit[10] = 100;
tooLegit[11] = 2000;
v.vibrate(tooLegit, 0);
// vibrate() skips over the values you didn't define, ie long[2] = 0, long[3] = 0, etc