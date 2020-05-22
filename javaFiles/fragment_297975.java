public boolean equals(Object ... others) {
    for (Object other: others) {
        if (this.equals(other)) {
            return true;
        }
    }
    return false;
}