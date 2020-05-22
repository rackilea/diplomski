class MathFunctions {
  final static double[] angles = {
    0.78539816339745d, 0.46364760900081d, 0.24497866312686d, 0.12435499454676d,
    0.06241880999596d, 0.03123983343027d, 0.01562372862048d, 0.00781234106010d,
    0.00390623013197d, 0.00195312251648d, 0.00097656218956d, 0.00048828121119d,
    0.00024414062015d, 0.00012207031189d, 0.00006103515617d, 0.00003051757812d,
    0.00001525878906d, 0.00000762939453d, 0.00000381469727d, 0.00000190734863d,
    0.00000095367432d, 0.00000047683716d, 0.00000023841858d, 0.00000011920929d,
    0.00000005960464d, 0.00000002980232d, 0.00000001490116d, 0.00000000745058d};
  final static double[] Kvalues = {
    0.70710678118655d, 0.63245553203368d, 0.61357199107790d, 0.60883391251775d,
    0.60764825625617d, 0.60735177014130d, 0.60727764409353d, 0.60725911229889d,
    0.60725447933256d, 0.60725332108988d, 0.60725303152913d, 0.60725295913894d,
    0.60725294104140d, 0.60725293651701d, 0.60725293538591d, 0.60725293510314d,
    0.60725293503245d, 0.60725293501477d, 0.60725293501035d, 0.60725293500925d,
    0.60725293500897d, 0.60725293500890d, 0.60725293500889d, 0.60725293500888d};

  public static double[] cordic(double theta, int n) {
    double[] v;
    if (theta < -Math.PI/2 || theta > Math.PI/2) {
      v = (theta < 0)? cordic(theta + Math.PI, n):cordic(theta - Math.PI, n);
      return new double[]{-v[0],-v[1]};
    }
    // You didn't initialise v properly
    v = new double[] {1.0d, 0, };
    double angle=angles[0], Kn=Kvalues[Math.min(n, Kvalues.length-1)];
    double sigma, factor, poweroftwo=1;
    for (int i=0; i<n; i++) {
      sigma = (theta < 0)? -1 : 1;
      factor = sigma*poweroftwo;
      v = new double[]{v[0] - v[1]*factor, v[0]*factor + v[1]};
      theta -= sigma*angle;
      poweroftwo /= 2;
      angle = (i+2 > angles.length)? angle/2 : angles[i+2];
    }
    return new double[]{v[0]*Kn, v[1]*Kn};
  }

  public static void main(String[] args)
  {
    double[] values;
    values = MathFunctions.cordic(Math.PI, 8);
    System.out.printf("cos(PI)   = %f, sin(PI)   = %f%n",values[0], values[1]);
    values = MathFunctions.cordic(Math.PI/2, 8);
    System.out.printf("cos(PI/2) = %f, sin(PI/2) = %f%n",values[0], values[1]);
    values = MathFunctions.cordic(0, 15);
    System.out.printf("cos(0)    = %f, sin(0)    = %f%n",values[0], values[1]);
  }
}