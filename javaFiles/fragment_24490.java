public static void main(String[] args) {
    Number[] ns = new Number[]{
            239999995.546,
            239989995.546,
               340000.007,
                   34.0000007,
           5699999999.0,
                  235.00000002,
                 9875.999999997,
                -4334.345345,
          23500000001.0,
                    0.30000007,
                   -0.053999949
    };
    DecimalFormat df = new DecimalFormat("0.#####");
    for(Number n : ns) {
        String s = df.format(simplify(n));
        System.out.println("    " + n + " is " + s);
    }
}