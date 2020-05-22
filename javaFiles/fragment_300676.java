public double getQuantity(int Q1, double P1, double P2, double P3) throws IllegalArgumentException {
    if ((P1 > P3 && P3 > P2) || (P1 < P3 && P3 < P2))
        return Q1*(P1-P3)/(P3-P2);
    else if (P1 == P3)
        return 0;
    else
        throw new IllegalArgumentException("P3 has to be between P1 and P2!");
}