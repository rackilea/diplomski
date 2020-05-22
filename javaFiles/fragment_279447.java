public static class ValueKey{
        String mdmId;
        String pgName;
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((mdmId == null) ? 0 : mdmId.hashCode());
            result = prime * result
                    + ((pgName == null) ? 0 : pgName.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ValueKey other = (ValueKey) obj;
            if (mdmId == null) {
                if (other.mdmId != null)
                    return false;
            } else if (!mdmId.equals(other.mdmId))
                return false;
            if (pgName == null) {
                if (other.pgName != null)
                    return false;
            } else if (!pgName.equals(other.pgName))
                return false;
            return true;
        }
        public ValueKey(String mdmId, String pgName) {
            super();
            this.mdmId = mdmId;
            this.pgName = pgName;
        }
    }