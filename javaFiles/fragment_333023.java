@Override
public int compare(MyObject m1, MyObject m2) {
    BigDecimal bd1 = BigDecimal.valueOf(m1.getTotalEnergy());
    BigDecimal bd2 = BigDecimal.valueOf(m2.getTotalEnergy());
    return bd1.compareTo(bd2);
}