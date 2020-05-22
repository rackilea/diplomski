public enum Logic {
    TRUE {
        @Override
        public Logic disj(Logic op) {}

        @Override
        public Logic neg() {}

        @Override
        public Logic conj(Logic op) {}
    },
    FALSE {
        @Override
        public Logic disj(Logic op) {}

        @Override
        public Logic neg() {}

        @Override
        public Logic conj(Logic op) {}
    },
    UNKNOWN {
        @Override
        public Logic disj(Logic op) {}

        @Override
        public Logic neg() {}

        @Override
        public Logic conj(Logic op) {}
    };

    public abstract Logic disj(Logic op);

    public abstract Logic neg();

    public abstract Logic conj(Logic op);

}