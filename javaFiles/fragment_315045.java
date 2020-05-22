public enum OpsOwner {
        selfService("Self Service - 2"), // Comma here!
        unassigned("Unassigned - 1");

        private String opsOwnerValue;

        OpsOwner(String value) {
            this.opsOwnerValue = value;
        }

        OpsOwner() {}

        public String opsOwnerValueValue() { return opsOwnerValue; }

        @Override
        public String toString() {
            return "opsOwnerValue{" +
                    "opsOwnerValue='" + opsOwnerValue + '\'' +
                    '}';
        }
    }