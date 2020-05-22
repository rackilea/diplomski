private void exportDataDet(File file) throws ParseException, IOException, ParsePropertyException, InvalidFormatException {

    List<ResultsDetails> detRes = generateResultsDetails();
    try(InputStream is = IdGenre.class.getResourceAsStream("/xlsTemplates/IdGenre/IdGenre_20-29_+12.xlsx")) {
        try (OutputStream os = new FileOutputStream("d:/IdGenreYOLO.xlsx")) {
            Context context = new Context();
            context.putVar("detRes", detRes);
            JxlsHelper.getInstance().processTemplate(is, os, context);
        }
    }
}


private void exportData(File file) throws ParseException, IOException, ParsePropertyException, InvalidFormatException {

    List<Results> rs = generateResults();
 try{
     String srcFilePath = "d:/IdGenreYOLO.xlsx";
     String destFilePath = "d:/IdGenreRes.xlsx";

     Map<String, List<Results>> beanParams = new HashMap<String, List<Results>>();
     beanParams.put("rs", rs);

     XLSTransformer former = new XLSTransformer();
     former.transformXLS(srcFilePath, beanParams, destFilePath);
    }
    finally{
        Path path = Paths.get("d:/IdGenreYOLO.xlsx");
        try{
            Files.delete(path);
        }
        finally{}
    }
}