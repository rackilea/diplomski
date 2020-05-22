FileWriter fw = null;
BufferedWriter writer = null;
//  File logFile = null;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try {
        LocalDate localDate = LocalDate.now();
        File logFile = new File("/home/ramesh/logReqRes"+localDate.getDayOfMonth()+localDate.getMonth()+".txt");
        boolean flag = logFile.createNewFile();
        System.out.println("flag :" + flag);
        if( flag || logFile.length() >= (1024*1024*1024)) 
            fw = new FileWriter(logFile, false);
        else
            fw = new FileWriter(logFile, true);

        writer = new BufferedWriter(fw);
        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {
            doFilterWrapped(wrapRequest(request), wrapResponse(response), filterChain);
        }
    } catch (IOException io) {
        io.printStackTrace();
    }
    catch (Exception ex) {
        ex.printStackTrace();

    }
    finally {

        try {

            if (writer != null)
                writer.close();

            if (fw != null)
                fw.close();

        } catch (IOException ex) {

            ex.printStackTrace();

        }
    }