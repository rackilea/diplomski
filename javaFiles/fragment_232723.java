if (hours<=35) {
    earned = (hours*regpay);
} else {
    overh = ((hours-35)*(regpay*1.5));
    earned = (35*regpay)+overh;
}