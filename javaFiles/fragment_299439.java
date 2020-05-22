protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    // Get formula input
        ...
    // Read Classifier and predict Success

    try {
        Classifier J48 = getClassifier();
        if (klassifizierer != null) {out.println("KLASSIFIZIERER IS LOADED");}
        predictionResult = J48.classifyInstance(DATA.firstInstance());
        DATA.classAttribute().value((int) ergebnis);
    return PredicitonResult;
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
 }