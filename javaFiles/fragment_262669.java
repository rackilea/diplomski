public ZipOutputStream CreatXml(int nbr_col, int iLineCounter,
              HashMap<String, Object> H, ServletOutputStream out , javax.servlet.http.HttpServletResponse response ) throws IOException {

            ZipOutputStream zipfile = null;
            String BookName = null;
            String BookID = null;
            int axisID = 11 ;
            String TemplateChild = null;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = null;
            try {
                    writeServerDebug("call function Create XML");
                    docBuilder = docFactory.newDocumentBuilder();
            } catch (ParserConfigurationException e2) {

                  e2.printStackTrace();
            }
            // Element : book_objects
            String tableName = "book_objects";
            org.w3c.dom.Document doc = docBuilder.newDocument();
            Element p_tableName = doc.createElement(tableName);
            doc.appendChild(p_tableName);

            // Element : object
            Element p_object = doc.createElement("object");
            String []platformeversion = JavaFunctions.convertStringToArray(Repository.Portal_Version, "=");
            p_object.setAttribute("version", platformeversion[1]+"  "+getVersion());
            p_tableName.appendChild(p_object);

            String tabCol = (String) (H.get("SQL_ColumnDesc"));
            String[] colName = JavaFunctions.convertStringToArray(tabCol, ", ");
            String [][]dep = null;
            dep = Dependances.sReturnDependance();
            String [][]colVal = new String [9][2];
            int c=0;
            for (int i = 1; i <= nbr_col; i++) {

                  String columnName = colName[i - 1];
                  columnName = columnName.replaceAll(" ", "");
                  columnName = columnName.replace("(", "");
                  columnName = columnName.replace(")", "");

                  Element nomChamps = doc.createElement(columnName);

                  String value = "";
                  value = "" + H.get(iLineCounter + "_" + i);
                  if(columnName.equalsIgnoreCase(Books.Column_Name)){
                      BookName = value;
                  }
                  if(columnName.equalsIgnoreCase(Books.Column_IDNum)){
                      BookID = value;
                  }
                  if(columnName.equalsIgnoreCase(Books.Column_axis_main_idnum)){
                      axisID = (Integer) H.get(iLineCounter + "_" + i);

                  }
                  if(columnName.equalsIgnoreCase(Books.Column_Template_Child)){
                      TemplateChild = (String) H.get(iLineCounter + "_" + i);

                  }

                  //retrieve the columns and their values for the dependencies
                  for(int cpt=0; cpt<5; cpt++){
                        if(dep[cpt][0].equalsIgnoreCase(columnName)){
                          colVal[c][0]=columnName;
                          colVal[c][1]= value;
                          c++;
                        }
                  }
                    nomChamps.appendChild(doc.createTextNode((String) value));
                    p_object.appendChild(nomChamps);

            }

            String label[] = JavaFunctions.convertStringToArray(TemplateChild, "/");
            String path = "C:\\Fovea_Repository/output/";
            File outputdirectory = new File (path);

            // Create the output file
            String fileName ="ExportDirectory"+ BookName +".zip";
            response.setHeader( "Content-Disposition", "filename=" + fileName );          
            Transformer tf = null;
            try {

                  tf = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException e1) {

                  e1.printStackTrace();
            } 
            try {
                  // Format XML
                  tf.setOutputProperty(OutputKeys.INDENT, "yes");
                  tf.setOutputProperty(OutputKeys.METHOD, "xml");
                  tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                  tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");
                  File directory = new File ("C:/Fovea_Repository/ExportDirectory/");
                  if(!directory.exists()){
                      directory.delete();
                      directory.mkdir();
                    }
                  DOMSource source = new DOMSource(doc);
                  StreamResult res = new StreamResult(new File("C:/Fovea_Repository/ExportDirectory/dependance.xml"));
                  tf.transform(source, res);



                  //create a zip file (Export_directory)
                  AppZip appZip = new AppZip();
                  String sourcefolder = "C:/Fovea_Repository/ExportDirectory"; 
                  String outputfoler  = " ";

                  ZipOutputStream returnFile = appZip.ZipFile(outputfoler , sourcefolder , out, BookName , BookID);
                  zipfile = returnFile;


            } catch (TransformerException e) {
                  e.printStackTrace();
            }

           return zipfile;
      }