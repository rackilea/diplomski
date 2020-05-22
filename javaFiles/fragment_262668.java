public String  performExport(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response, 
        String p_sBook_ID,  String p_sUser_ID, String p_sFormat) {

        String sReturn = _Return_OK;
            try {

                 writeServerDebug("performExport(req,resp,'" + p_sBook_ID + "'," + p_sUser_ID + "," + p_sFormat + "):start");

                  // ====================================================
                  // = Get the template directory
                  // ====================================================
                  FilerManager myFiler = new FilerManager();
                  String sInputPath = myFiler.getDirectory(
                  FilerManager.DirectoryKind_Users, true);

                  // ====================================================
                  // = Working variables JDBC objects.
                  // ====================================================
                   Connection con = null;
                   Statement stmt = null;
                   ResultSet rs = null;
                   String SQL = "";

                  try {
                        writeServerDebug("performExport >> START");
                        // ---------------------------------------------------------
                        // - Establish the connection.
                        // ---------------------------------------------------------
                        con = _RepositoryBridge.getSourceDataBaseConnection();
                  } catch (Exception ex) {
                        sReturn = Repository._Return_KO;
                  }

                  HashMap<String, Object> _hCacheBook = new HashMap<String, Object>();
                  try {
                        int iSrcCount = get_RepositoryBridge().cacheQueryData("SELECT TOP(1) * FROM " + Books.Table + " WHERE " + Books.Column_IDNum + "=" + p_sBook_ID,  _hCacheBook, "DataBase_Source");
                        int iColCount = (Integer) (_hCacheBook.get("SQL_ColumnCount"));
                        String sColDesc = (String) (_hCacheBook.get("SQL_ColumnDesc"));
                        String sColValues = (String) (_hCacheBook
                                   .get("SQL_ColumnValues"));

                        int nbrCol = (Integer) (_hCacheBook.get("SQL_ColumnCount"));
                        String sContentType = "application/vnd.ms-objx";
                        response.setContentType(sContentType);

                        ServletOutputStream outStream = new ServletOutputStream() {
                            @Override
                            public void write(int arg0) throws IOException {
                                // TODO Auto-generated method stub
                            }
                        };

                        outStream = response.getOutputStream();
                        this.CreatXml(nbrCol, 1, _hCacheBook, outStream, response );      
                        outStream.flush();
                        outStream.close();
                  }

                  catch (Exception ex) {
                        System.out.println("I AM IN THE EXCEPTION :");
                        ex.printStackTrace();
                  }

    }
            catch (Exception e) {
                writeServerDebug("ERROR:" + e.getLocalizedMessage());
                sReturn = Repository._Return_KO;
          }
            return sReturn;
      }