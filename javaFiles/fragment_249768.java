public enum BloodTest {
    AAA(10) {
        @Override
        public boolean isRequired(MedicalRecord medicalRecord) {
            return medicalRecord.includes("someDisease");
        }
    },
    BBB(15) {
        @Override
        public boolean isRequired(MedicalRecord medicalRecord) {
            return ! medicalRecord.hasTakenBloodTestsLately();
        }
    },
    CCC(20) { // ... also implements the abstract method and so on

    private final int threshold;

    private BloodTest(int threshold) {
        this.threshold = threshold;
    }

    public boolean hasPassed(int value) {
        return value <= threshold;
    }

    public abstract boolean isRequired(MedicalRecord medicalRecord);

    // ... same as above
}