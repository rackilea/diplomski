enum Ops implements Op {
    Nop{
        @Override
        public int filter(int old, int now) {
            // Unchanged.
            return now;
        }
    },
    Diff{
        @Override
        public int filter(int old, int now) {
            return a(now)
                    | (Colour.MidGrey + (r(now) - r(old))) << 16
                    | (Colour.MidGrey + (g(now) - g(old))) << 8
                    | (Colour.MidGrey + (b(now) - b(old)));
        }
    };
}