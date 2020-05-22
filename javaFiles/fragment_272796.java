int startNum = Integer.parseInt(scan.nextLine());
int endNum = Integer.parseInt(scan.nextLine());

for (int i = startNum; i <= endNum; i++) {
    for (int j = startNum; j <= endNum; j++) {
        for (int k = startNum; k <= endNum; k++) {
            for (int l = startNum; l <= endNum; l++) {

                boolean firstCase = i % 2 == 0 && l % 2 == 1;
                boolean secondCase = l % 2 == 0 && i % 2 == 1;

                // now when we print, we can ask if we are in the first OR the second case
                if (firstCase || secondCase) {
                    System.out.printf("%d%d%d%d ",i,j,k,l);
                }
            }
        }
    }
}