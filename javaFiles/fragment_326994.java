public boolean equals(Object obj) {
    if ((null == obj) || (obj.getClass() != UUID.class))
        return false;
    UUID id = (UUID)obj;
    return (mostSigBits == id.mostSigBits &&
            leastSigBits == id.leastSigBits);
}