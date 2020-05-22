public class MedicalPolicy implements PolicyType {
    private static final AtomicInteger counter = new AtomicInteger();

    private final int id;

    public MedicalPolicy(
            final LocalDate effective,
            final LocalDate expiry,
            final ArrayList<Beneficiary> beneficiaries){
        id = counter.incrementAndGet();
    }
}