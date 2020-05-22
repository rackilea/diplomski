try {
    FileOutputStream out = new FileOutputStream("C:\\Documents and Settings\\INGENIERIA2\\Mis documentos\\Informe.xls");
    exceldoc.write(out);
    out.close();
} catch (FileNotFoundException ex) {
    Logger.getLogger(PruebaExcel.class.getName()).log(Level.SEVERE, null, ex);
}