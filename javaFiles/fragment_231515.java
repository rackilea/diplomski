package test;

public class Cubic {
    private double[] Raices = new double[3];

    public static void main(String[] args) throws ComplexException {
        double[] raices = new Cubic().getRaices(2, -4, -22, 24);
        System.out.println(raices[0] + "," + raices[1] + "," + raices[2]);
    }

    public double[] getRaices(double a, double b, double c, double d) throws ComplexException {
        if (a == 0) {
            double discriminante = Math.pow(c, 2) + ((-4) * b * d);
            if (discriminante >= 0) {
                this.Raices[0] = (c * (-1) + Math.sqrt(discriminante)) / (2 * b);
                this.Raices[1] = (c * (-1) - Math.sqrt(discriminante)) / (2 * b);
            } else {
                throw new ComplexException("No hay solucion Real");
            }

        } else {
            double f = ((3 * c / a) - (Math.pow(b, 2) / Math.pow(a, 2))) / 3;
            System.out.println("f=" + f);
            double g = ((2 * Math.pow(b, 3) / Math.pow(a, 3)) - (9 * b * c / Math.pow(a, 2)) + (27 * d / a)) / 27;
            System.out.println("g=" + g);
            double h = (Math.pow(g, 2) / 4) + (Math.pow(f, 3) / 27);
            System.out.println("h=" + h);
            if (f + g + h == 0) {
                Raices[0] = Math.cbrt(d / a) * (-1);
                Raices[1] = Math.cbrt(d / a) * (-1);
                Raices[2] = Math.cbrt(d / a) * (-1);
            } else {
                if (h <= 0) {
                    double i = Math.sqrt((Math.pow(g, 2) / 4) - h);
                    double j = Math.cbrt(i);
                    double k = Math.acos(-1 * (g / 2 / i));
                    System.out.println("k=" + k + " ");
                    double l = j * (0 - 1);
                    System.out.println("l=" + l + " ");
                    double m = Math.cos(k / 3);
                    System.out.println("m= " + m + " ");
                    double n = Math.sqrt(3) * Math.sin(k / 3);
                    System.out.println("n= " + n + " ");
                    double p = (b / (3 * a) * (0 - 1));
                    System.out.println("p= " + p + " ");
                    Raices[0] = 2 * j * Math.cos(k / 3) - (b / (3 * a));
                    Raices[1] = (l * (m + n)) + p;
                    Raices[2] = (l * (m - n)) + p;
                } else {
                    double r = ((0 - 1) * (g / 2)) + Math.sqrt(h);
                    double s = Math.cbrt(r);
                    double t = ((0 - 1) * (g / 2)) - Math.sqrt(h);
                    double u = Math.cbrt(t);
                    throw new ComplexException(
                            "2 de las raices son imaginarias pero una raiz es real: " + Math.floor(Raices[0] = (s + u) - (b / (3 * a))));
                }
            }
        }
        return Raices;
    }
}