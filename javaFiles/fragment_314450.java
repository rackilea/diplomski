double GPa = Constants.GPascals;

    public int[] i = new int[51];
    public int eos[];
    public double rho0[];
    public double c[];
    public double nn[];
    public double Ks0[];
    public double Ksp[];

    public PlanMat() {
        i = new int[51];
        eos = new int[51];
        rho0 = new double[51];
        c = new double[51];
        nn = new double[51];
        Ks0 = new double[51];
        Ksp = new double[51];

        i[0] = 0;
        eos[0] = 0;
        rho0[0] = 0;
        c[0] = 0;
        nn[0] = 0;
        Ks0[0] = 0;
        Ksp[0] = 0;
    }
}