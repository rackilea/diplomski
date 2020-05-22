public class SO2 {
        private SO2(File xml){
            wb = new XSSFWorkbook(); //Workbook to create
            sheet = wb.createSheet(); //Sheet to write to

                try {
                    SO2.retrieveSaxParser().parse(xml, SO2.retrieveHandler()); //Begin parse
                     Path file = Paths.get(System.getProperty("user.home"), "Desktop", "XMLTest.xlsx"); //Where to write file
                     wb.write(new FileOutputStream(file.toString()));
                } catch (SAXException | IOException | ParserConfigurationException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                 System.exit(0);
            }

            protected static void instertUpdate(String data, int columnNum, int rowNum) {//Method to add to spreadsheet
                /*The below writes to the file, the row if statements are there to stop the method
                 * overwriting any rows already created
                 */

                if(row != null){
                    if(row.getRowNum() != rowNum){
                        row = sheet.createRow(rowNum);
                    } 
                } else {
                    row = sheet.createRow(rowNum);
                }

                cell = row.createCell(columnNum);//Make our cell
                cell.setCellValue(data);//Write to it
            }

            private static SAXParser retrieveSaxParser() throws ParserConfigurationException, SAXException{
                return SAXParserFactory.newInstance().newSAXParser();//Get parser
            }

            private static DefaultHandler retrieveHandler() {
                DefaultHandler handler = new DefaultHandler(){//Handler with methods required for parsing xml

                    @Override
                    public void startElement(String uri, String localName,String qName,  Attributes attributes) throws SAXException {
                        if(startWasPrevious == true){//Start indenting after the first element tag processed
                            indent++;
                        }

                        rowNumber++;//Move row down for each tag
                        columnNumber = indent; //Cell number set to current indent level

                        SO2.instertUpdate("<" + qName + ">",     columnNumber, rowNumber);//Insert

                        startWasPrevious = true; //For formatting
                        previous = startTag;//For formatting
                    }

                    @Override
                    public void endElement(String uri, String localName, String qName) throws SAXException {
                        if(startWasPrevious == false){//For removal of indentation
                            indent--;
                        }

                        if(!previous.equals("text")){//If text wasn't last part parsed then set column to indent
                            columnNumber = indent;
                        } else{//If text was processed last move cell across
                            columnNumber++;
                        }

                        if(previous.equals("end")){//Move to a newline if last parsed element was an ending tag
                            rowNumber++;
                        }

                        if(startWasPrevious == false){ //If there was no text previously
                            SO2.instertUpdate("</" + qName + ">", columnNumber, rowNumber); 
                        } else { //If there was text then this will be enclosing end tag
                            SO2.instertUpdate("</" + qName + ">", columnNumber, rowNumber);
                        }
                        startWasPrevious = false; //For formatting
                        previous = endTag;
                    }

                    @Override
                    public void characters(char ch[], int start, int length) throws SAXException {
                        String s = new String(ch, start, length).trim();//Get text
                        if(s.length() > 0){
                            columnNumber++; //Move column number along
                            SO2.instertUpdate(s, columnNumber, rowNumber);
                            previous = text; 
                        }
                    }
                };
                return handler;
            }


            //Main
            public static void main(String[] args) {
                JFrame file = new JFrame("File choice. . .");
                file.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                FileDialog dialog = new FileDialog(file, "Choose a file", FileDialog.LOAD);//Get XML File
                dialog.setDirectory(Paths.get(System.getProperty("user.home")).resolve("Desktop").toString());
                dialog.setFile("*.xml");
                dialog.setVisible(true);

                if(dialog.getFile() == null){
                    System.exit(0);
                } else {
                    xmlFile = new File(dialog.getDirectory() + dialog.getFile());
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new SO2(xmlFile);
                        }
                    });
                }
            }


            private static File xmlFile;
            private static XSSFWorkbook wb;
            private static Sheet sheet;
            private static Row row;
            private static Cell cell;
            private static boolean startWasPrevious = false; //For formatting purposes
            private static int rowNumber = -1; //Hold row number
            private static int columnNumber = 0;//Hold number of cell to wtite to
            private static int indent;//For indenting
            private static String previous = "";//To know what was last processed
            private static final String endTag = "end";//Values for previous to hold
            private static final String text = "text";//Values for previous to hold
            private static final String startTag = "start";//Values for previous to hold
      }