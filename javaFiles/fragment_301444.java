static FileService fileService;

public static final String PASTA_RAIZ = "P:\\";
public static final String INFORMACOES = "1. Informacoes";
public static final String QUESTIONARIOS = "2. Questionarios";
public static final String RELATORIOS = "3_Relatorio";

public static File[] listarArquivos(final String empresa, final String tipo) {
File file = new File(PASTA_RAIZ + empresa + File.separator + tipo + File.separator);
return file.listFiles();
}

public static String retornarCaminhoPasta(final String empresa, final String tipo) {
File file = new File(PASTA_RAIZ + empresa + File.separator + tipo + File.separator);
return file.getAbsolutePath();
}