public class StochasticSimulationProcess extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    static int matrixPre[][];
    static int matrixPost[][];
    static int m;// the number of reactions
    static int n;// the number of species
    static double[] h;// the hazard for each reaction
    static double[] rate;
    static int[] state;
    static double newTime;
    static int max;
    static double Tmax;// the overall reaction time
    Vector<Double> timeList;
    static double H;
    Vector<int[]> allStateList;
    static String[] strs;
    XYSeriesCollection dataset;


    public StochasticSimulationProcess(String s) {
        super(s);
        newTime = 0;

    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception {

        // input the number of species
        System.out.println("Enter the number of species:");
        int n = sc.nextInt();

        // input the number of reactions
        System.out.println("Enter the number of reactions:");
        int m = sc.nextInt();

        //
        int[][] matrixPre = new int[m][n];
        enterMatrixDataPre(sc, matrixPre, m, n);
        printMatrixPre(matrixPre, m, n);

        // convert the 2d int to 2d double
        double[][] matrixPre2 = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrixPre2[i][j] = (double) matrixPre[i][j];
        }

        RealMatrix PreMatrix = new Array2DRowRealMatrix(matrixPre2);

        // remember to add space key when doing the typing
        int[][] matrixPost = new int[m][n];
        enterMatrixDataPost(sc, matrixPost, m, n);
        printMatrixPost(matrixPost, m, n);

        // convert the 2d int to 2d double
        double[][] matrixPost2 = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrixPost2[i][j] = (double) matrixPost[i][j];
        }

        RealMatrix PostMatrix = new Array2DRowRealMatrix(matrixPost2);

        //
        RealMatrix matrixSubtract = PreMatrix.subtract(PostMatrix);
        System.out.println("So the transpose matrix after subtraction is:\t" + matrixSubtract.transpose());

        // input the default maxium time of the whole reaction
        System.out.println("Enter the maxium time of the whole reaction:");
        double Tmax = sc.nextDouble();

        // input the name of all the species
        System.out.println("Enter the name of all species");
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        // input the rate constant of all the reactions(the coefficient), must be a
        // double
        System.out.println("Enter the rate constant of each reaction:");
        Double[] rate = new Double[m];
        for (int r = 0; r < m; r++) {
            rate[r] = sc.nextDouble();
        }

        //
        Vector<Double> timeList = new Vector<Double>(0);
        Vector<int[]> allStateList = new Vector<int[]>(0);
        timeList.add(newTime);

        // input the initial states of numbers of molecules
        System.out.println("Enter the initial molecule numbers of all species:");
        int[] state = new int[n];
        for (int i = 0; i < n; i++) {
            state[i] = sc.nextInt();
        }

        allStateList.add(state);
        timeLoop:
        while (newTime < Tmax) {
            for (int loopIndex = 0; loopIndex < allStateList.size(); loopIndex++) {
                // calculate the hazard for each reaction and the general hazard
                double[] h = new double[m];
                H = 0;
                try {
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            h[i] = rate[i] * CombinatoricsUtils.binomialCoefficientDouble(
                                    allStateList.get(loopIndex)[j], (int) (PreMatrix.getRowVector(i).toArray()[j]));
                            H += h[i];
                        }
                    }
                }

                catch (NumberIsTooLargeException exceptionn) {
                    System.out.println("One of the species has been exhausted and there is no next firing");
                    break timeLoop;
                }
                System.out.println("So the general hazard is:" + H);

                // select a random reaction time
                Random random = new Random();
                double tau = (1 * Math.log(1 / random.nextDouble())) / H;
                System.out.println("So the random reaction time is" + tau);

                // put the newTime
                newTime = timeList.get(loopIndex) + tau;
                System.out.println("So the new reaction time is:" + newTime);
                timeList.add(newTime);

                // select a random reaction j
                Random random2 = new Random();
                int index = 0;
                double hi =0;
                for (int i = 0; i < m; i++) {
                    hi +=h[i];
                    if (hi >= random2.nextDouble() * H) {
                        index = i;
                        break;
                    }
                }
                System.out.println("So the next simulated event is:" + index);

                // Update the state
                double[] vectorDoubleArray = matrixSubtract.transpose().getColumnVector(index).toArray();
                int[] intArray = new int[n];
                for (int i = 0; i < n; i++) {
                    intArray[i] = (int) vectorDoubleArray[i];
                }
                int[] newState = new int[n];
                int newS = 0;
                for (int p = 0; p < n; p++) {
                    newS = intArray[p] + allStateList.get(loopIndex)[p];
                    newState[p] = newS;
                }
                System.out.println("Right now the molecule number of all species are:" + Arrays.toString(newState));
                allStateList.add(newState);
            }

            // close the scanner
            sc.close();
        }


        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries[] species = new XYSeries[n];
        for (int j =0; j<n; j++) {
            species[j]=new XYSeries(""+strs[j]+Integer.toString(j));
        }


        for (int j =0; j<n; j++) {
            for (int k=0; k< allStateList.size();k++) {
            species[j].add(timeList.get(k).doubleValue(), allStateList.get(k)[j]);
        }
            dataset.addSeries(species[j]);
    }

        // plot out the graph
        System.out.println("TEST");

        JFreeChart chart = ChartFactory.createXYLineChart(
                "SSA Modeling", 
                "time", 
                "Number of Molecules", 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false
        );

         ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            chartPanel.setBackground(Color.white);
           XYPlot plot = chart.getXYPlot();


            XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

            for (int j =0; j<n;j++){
             renderer.setSeriesPaint(j, Color.RED);
             renderer.setSeriesStroke(j, new BasicStroke(2.0f));
            }


            plot.setRenderer(renderer);
            plot.setBackgroundPaint(Color.white);

            plot.setRangeGridlinesVisible(false);
            plot.setDomainGridlinesVisible(false);


           chart.getLegend().setFrame(BlockBorder.NONE);

            chart.setTitle(new TextTitle("Stochastic Simulation Algorithm",
                            new Font("Serif", Font.BOLD, 18)
                    )
            );

        SwingUtilities.invokeLater(() -> {
            StochasticSimulationProcess ex = new StochasticSimulationProcess("SSA");
            ex.setContentPane(chartPanel);
            ex.pack();
            ex.setLocationRelativeTo(null);
            ex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            ex.setVisible(true);

        });
    }

    public static void enterMatrixDataPre(Scanner sc, int[][] matrixPre, int m, int n) {
        System.out.println("Enter Matrix pre data");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixPre[i][j] = sc.nextInt();
            }
        }
    }

    public static void printMatrixPre(int[][] matrixPre, int m, int n) {
        System.out.println("Matrix pre is:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrixPre[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void enterMatrixDataPost(Scanner sc, int[][] matrixPost, int m, int n) {
        System.out.println("Enter Matrix post data");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixPost[i][j] = sc.nextInt();
            }
        }
    }

    public static void printMatrixPost(int[][] matrixPost, int m, int n) {
        System.out.println("Matrix post is:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrixPost[i][j] + "\t");
            }
            System.out.println();
        }
    }
}