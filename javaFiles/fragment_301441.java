public List<StreamedContent> getAnexosInformacoes() {
List<StreamedContent> resultado = new ArrayList<StreamedContent>();
File[] arquivos = FileHelper.listarArquivos(selected.getEmpresa().getDiretorio(), FileHelper.INFORMACOES);

if (arquivos != null) {
    for (File arquivo : arquivos) {
    InputStream stream = null;
    try {
        stream = new FileInputStream(arquivo.getAbsolutePath());
        String extensao = arquivo.getName().substring(arquivo.getName().lastIndexOf(".") + 1);

        StreamedContent file = new DefaultStreamedContent(stream,MimeTypes.valueOf(extensao).getMimeType(),arquivo.getName());
        resultado.add(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    try {
        stream.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}

return resultado;
}