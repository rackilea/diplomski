StreamedContent arquivo;

public void prepararArquivoInformacoes(final StreamedContent arq) {
InputStream stream = null;
String caminho = FileHelper.retornarCaminhoPasta(selected.getEmpresa().getDiretorio(), FileHelper.INFORMACOES);
try {
    stream = new FileInputStream(caminho + File.separator + arq.getName());
    this.arquivo = new DefaultStreamedContent(stream, MimeTypes.valueOf("pdf").getMimeType(), arq.getName());
} catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
}

public StreamedContent getArquivo() {
return arquivo;
}