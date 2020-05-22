int count = 0;
int gLimit = 0;
for (int b = 0; b<ArrBoys.size();b++) {
    if(gLimit == ArrGirls.size()) {
        System.out.println("no more girl for boy " + ArrBoys.get(b));
    }
    for (int g = gLimit; g<ArrGirls.size();g++) {
        {

            int dif = ArrBoys.get(b) - ArrGirls.get(g);
            if (Math.abs(dif) <= k) {
                System.out.println("we took " + ArrBoys.get(b) + " from boys with "
                        + ArrGirls.get(g) + " from girls, thier dif < " + k);
                gLimit++;
                count++;
                break;
            } else if (dif > k) {
                System.out.println("we try " + ArrBoys.get(b) + " from boys with " + ArrGirls.get(g) + " from grils but thier dif > " + (int) k + ", girl too small, excluded");
                gLimit++;
            } else if (dif < -k) {
                System.out.println("we try " + ArrBoys.get(b) + " from boys with " + ArrGirls.get(g) + " from grils but thier dif > " + (int) k + ", boy too small, excluded");
                break;
            }
        }
    }
}