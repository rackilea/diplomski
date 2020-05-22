public class assignment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = 0, n = 0;
        int[][] x = new int[6][2];
        double a, b, c, a1, b1, c1;
        String y = "";
        System.out.println("Please enter six points,");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++)
                x[i][j] = input.nextInt();
        }

        for (int i = 0; i < 30; i++)
            System.out.print("--");
        System.out.print("\n\t\t\t\tTypes of Triangles\n");
        for (int i = 0; i < 30; i++)
            System.out.print("--");
        System.out.println();
        System.out.println("Point1\t\tPoint2\t\tPoint3\t\tType of Triangle");
        for (int i = 0; i < 30; i++)
            System.out.print("--");
        System.out.println();

        for (int j = 0; j < 4; j++) {
            for (int k = j + 1; k < 5; k++) {
                for (int l = k + 1; l < 6; l++) {

                    a = Math.sqrt(Math.pow((x[j][0] - x[k][0]), 2) + Math.pow((x[j][1] - x[k][1]), 2));
                    b = Math.sqrt(Math.pow((x[j][0] - x[l][0]), 2) + Math.pow((x[j][1] - x[l][1]), 2));
                    c = Math.sqrt(Math.pow((x[l][0] - x[k][0]), 2) + Math.pow((x[l][1] - x[k][1]), 2));
                    c1 = Math.max(Math.max(a, b), c);
                    b1 = Math.min(Math.min(a, b), c);
                    a1 = (a + b + c) - c1 - b1;
                    if (a1 > 0 && b1 > 0 && c1 > 0 && a1 + b1 > c1 && b1 + c1 > a1 && c1 + a1 > b1) {
                        if (Math.pow(c1, 2) == (Math.pow(b1, 2) + Math.pow(a1, 2))) {
                            if (a1 == b1 || b1 == c1 || c1 == a1) {
                                y = ("Right-angled\tIsosceles");
                            } else if (a1 != b1 && b1 != c1 && c1 != a1) {
                                y = ("Right-angled\tScalene");
                            }
                        } else if (a1 == b1 || b1 == c1 || c1 == a1) {
                            y = ("Isosceles");
                        } else if (a1 != b1 && b1 != c1 && c1 != a1) {
                            y = ("Scalene");
                        }
                    } else {
                        y = ("Non-triangle");
                    }
                    System.out.println("(" + x[j][0] + "," + x[j][1] + ")\t\t" + "(" + x[k][0] + "," + x[k][1] + ")\t\t" + "(" + x[l][0] + "," + x[l][1] + ")\t\t" + y);

                }
            }
        }
        System.out.print("Maximum area of triangle =" + area(x));
        //System.out.print("Maximum area of triangle =" + Math.min(area(x)));
    }

    public static double area(int[][] n) {
        double s = 0;
        double max = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = j + 1; k < 5; k++) {
                for (int l = k + 1; l < 6; l++) {
                    double a = Math.sqrt(Math.pow((n[j][0] - n[k][0]), 2) + Math.pow((n[j][1] - n[k][1]), 2));
                    double b = Math.sqrt(Math.pow((n[j][0] - n[l][0]), 2) + Math.pow((n[j][1] - n[l][1]), 2));
                    double c = Math.sqrt(Math.pow((n[l][0] - n[k][0]), 2) + Math.pow((n[l][1] - n[k][1]), 2));
                    s = (a + b + c) / 2;
                    if (s > max) {
                        max = s;
                    }
                }
            }
        }
        return max;
    }
}