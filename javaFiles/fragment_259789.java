public int getLeft() {
        return field >> 16; // sign bit is significant
    }

    public int getRight() {
        return (short) (field & RIGHT); gets cast back to signed int
    }