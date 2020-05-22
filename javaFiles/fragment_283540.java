public boolean withDrawal (double wD){
    if (wD > balance) {
        return false;
    }
    else {
        balance = balance - wD;
        return true;
    }
}