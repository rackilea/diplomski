final EqualsStrategy strategy = new org.jvnet.hyperjaxb3.lang.builder.ExtendedJAXBEqualsStrategy() {

        @Override
        public boolean equals(ObjectLocator leftLocator,
                ObjectLocator rightLocator, Object lhs, Object rhs) {
            if (!super.equals(leftLocator, rightLocator, lhs, rhs)) {
                logger.debug("Objects are not equal.");
                super.equals(leftLocator, rightLocator, lhs, rhs);
                logger.debug("Left: "
                        + (lhs == null ? "null" : lhs.toString()));
                if (leftLocator != null) {
                    logger.debug("At [" + leftLocator.getPathAsString()
                            + "].");
                }
                logger.debug("Right: "
                        + (rhs == null ? "null" : rhs.toString()));
                if (rightLocator != null) {
                    logger.debug("At [" + rightLocator.getPathAsString()
                            + "].");
                }
                return false;
            } else

            {
                return true;
            }
        }

    };