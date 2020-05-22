public class MyFTPClass {

private static FTPFile[] obterArquivosDiretorio(FTPClient ftp, String dirPath) throws IOException {
    String cwd = ftp.printWorkingDirectory();

    ftp.changeWorkingDirectory(dirPath);
    FTPFile[] files = ftp.listFiles();
    ftp.changeWorkingDirectory(cwd);

    return files;
}

public static void main(String args[]) throws SAXException, ParserConfigurationException {

    // Create an instance of FTPClient
    FTPClient ftp = new FTPClient();
    try {

        // Establish a connection with the FTP URL
        ftp.connect("caminho_ftp");
        // Enter user details : user name and password
        boolean isSuccess = ftp.login("usuario", "senha");

        if (isSuccess) {
            // Fetch the list of names of the files. In case of no files an
            // empty array is returned

            String path = "ArquivosNotas";
            FTPFile[] listedDirectories = obterArquivosDiretorio(ftp, path);

            int countXml = 1;
            // Iterate on the returned list to obtain name of each file
            for (FTPFile file : listedDirectories) {

                if (file.getName().toLowerCase().contains("xml")) {

                    System.out.println();
                    System.out.println("Lendo " + countXml + " xml");
                    System.out.println();

                    InputStream stream = ftp.retrieveFileStream("ArquivosNotas/" + file.getName());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

                    // xml vai virar uma string para depois fazer o parse para o document
                    StringBuilder sb = new StringBuilder();
                    String inline = "";
                    while ((inline = reader.readLine()) != null) {
                        sb.append(inline);
                    }

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();

                    // convert string do xml para xml em document
                    Document doc = (Document) builder.parse(new ByteArrayInputStream(sb.toString().getBytes()));

                    NodeList listaDeVenda = doc.getElementsByTagName("venda");
                    int tamanhoDaLista = listaDeVenda.getLength();

                    NodeList listaDeProdutos = doc.getElementsByTagName("item");
                    int tamanhoDaListaDeProdutos = listaDeProdutos.getLength();

                    System.out.println();
                    System.out.println("Qtde itens xml " + tamanhoDaListaDeProdutos);

                    System.out.println("Finalizado " + countXml + " xml");
                    System.out.println();
                    countXml++;

                    stream.close();
                    reader.close();
                    ftp.completePendingCommand();
                }

            }
        }

        ftp.logout();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            ftp.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}