Double AE;

if (TS > Ex) {
    AE = 0.00;
} else {
    AE = (Ex - TS);
};

Double TBTAT = (TS - Ex);
Double Exx = 2864.17;    

Double TAT;

if (TBTAT > Exx) {
    TAT = (Exx * 0.2);
} else {
    TAT = (TBTAT * 0.2);
};