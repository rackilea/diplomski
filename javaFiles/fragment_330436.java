private void calculatePF(BigDecimal[] pf) {
    pf[1] = pf[1].add(new BigDecimal(10));
    pf[0] = pf[0].add(new BigDecimal(10));
}
@Test
public void autoPlaceUser() throws Exception{
    BigDecimal pf[] = new BigDecimal[] {
        BigDecimal.ZERO, BigDecimal.ZERO
    };
    calculatePF(pf);
    System.out.println("rightPF : "+pf[1]);
    System.out.println("leftPF : "+pf[1]);
}