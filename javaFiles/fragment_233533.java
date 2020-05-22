class LMF {
    LMF() {
    }

    public int methodLMF(int x) {
        return new HF().methodHF(x) + new BF().methodBF(x);
    } // should return methodHF+methodBF

    // class HF
    class HF {
        HF() {
        }

        public int methodHF(int x) {
            return x++;
        }
    }

    // class BF
    class BF {
        BF() {
        }

        public int methodBF(int x) {
            return x++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LMF().methodLMF(1));
    }
}