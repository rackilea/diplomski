protected double difference(int index, double val1, double val2) {
    switch (m_Data.attribute(index).type()) {
        case Attribute.NOMINAL:
            if (Utils.isMissingValue(val1) || Utils.isMissingValue(val2)
                || ((int) val1 != (int) val2)) {
                return 1;
            } else {
                return 0;
            }
        ....
}