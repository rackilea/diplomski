private static <T extends TwoString> T eqTwoString(final TwoString twoString) {
    reportMatcher(new IArgumentMatcher() {
        /** Required to get nice output */
        public void appendTo(StringBuffer buffer) {
            buffer.append("eqTwoString(" + twoString.getString1() + "," + twoString.getString2() + ")");
        }

        /** Implement equals basically */
        public boolean matches(Object object) {
            if (object instanceof TwoString) {
                TwoString other = (TwoString) object;
                // Consider adding null checks below
                return twoString.getString1().equals(object.getString1()) && twoString.getString2().equals(object.getString2());
            }
            else {
                return false;
            }
        }
    });
    return null;
}