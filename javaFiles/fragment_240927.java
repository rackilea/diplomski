public static void main(String[] args) {
    DecimalFormat df = new DecimalFormat("##.##%");
    double nbError, nbTest = 100000;
    for (int charge = 1; charge < 11; charge++) {
        nbError = 0;
        for (int j = 0; j < nbTest; j++) {
            nbError += (isError(charge) ? 0 : 1);
        }
        System.out.println(charge + " -> " + df.format(nbError / nbTest));
    }
}


1 -> 100   %   ~100%
2 ->  90,06%   ~ 90%
3 ->  80,31%   ~ 80%
4 ->  69,97%   ~ 70%
5 ->  59,92%   ~ 60%
6 ->  49,9 %   ~ 50%
7 ->  39,9 %   ~ 40%
8 ->  30,08%   ~ 30%
9 ->  19,84%   ~ 20%
10 -> 10,18%   ~ 10%