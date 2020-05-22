class Top {
    Top() {
        new Exception().printStackTrace(System.out);
    }
}

class Bottom extends Top {
    public static void main(String[] args) {
        new Bottom();
    }
}