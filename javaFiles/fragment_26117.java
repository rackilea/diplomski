ByteArrayOutputStream byteArrayOutputStreaml = new ByteArrayOutputStream();
                Document document = new Document(PageSize.A4, 36, 36, 120, 36);
                PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStreaml); // Do this BEFORE
                HeaderFooterPageEvent event = new HeaderFooterPageEvent("", "", "");
                writer.setPageEvent(event);
                document.open();

                   CSSResolver cssResolver =
                            XMLWorkerHelper.getInstance().getDefaultCssResolver(true);

                   HtmlPipelineContext htmlContext = new HtmlPipelineContext(null);
                     //custom tag processor
                    TagProcessorFactory factory = Tags.getHtmlTagProcessorFactory();
                    factory.addProcessor(
                        new Span(){
                            @Override
                            public List<Element> end(WorkerContext ctx, Tag tag, List<Element> l) {
                                List<Element> list = new ArrayList<Element>(1);
                                try {
                                    list.add(getImageChunk(ctx, tag.getAttributes()));
                                } catch (BadElementException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (MalformedURLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                return list;
                            }
                        },
                        "ean");
                    htmlContext.setTagFactory(factory);
                    htmlContext.autoBookmark(false);


                    PdfWriterPipeline pdf = new PdfWriterPipeline(document, writer);
                    HtmlPipeline html = new HtmlPipeline(htmlContext, pdf);
                    CssResolverPipeline css = new CssResolverPipeline(cssResolver, html);

                    XMLWorker worker = new XMLWorker(css, true);
                    XMLParser p = new XMLParser(worker);
                    //here employee is my entity's object which has byte[] property.
                    String imgStr = "<b>bold</b><ean value="+employee.getId()+"/>";
                    p.parse(new ByteArrayInputStream(imgStr.getBytes()));
                    document.close();

      public Chunk getImageChunk(WorkerContext ctx, Map<String, String> attributes) throws 
                BadElementException, MalformedURLException, IOException {
            MapContext mc;
            try {
                mc = (MapContext)ctx.get("com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline");
            } catch (NoCustomContextException ex) {
               throw new ExceptionConverter(ex);
            }
           PdfWriter writer = (PdfWriter) mc.get("WRITER");
           //employeeService is service layer of three tier architecture
           Image img = Image.getInstance(employeeService.getEmployeeById(Integer.parseInt(attributes.get("value"))).getEmployeePhoto());
           img.scaleAbsolute(80, 80);
           return new Chunk(img, 0, 0, true);
      }