import java.util.ArrayList;
import java.util.List;

public class Tabularize {

    static String input =
        "acessos.add(new AcessoBean(\"Ferramentas\", \"Parâmetros\", \"Parâmetros\", \"Pesquisa\", \"ppaParametrosList\", null, TipoAcessoBean.TELA));\n" + 
        "acessos.add(new AcessoBean(\"Ferramentas\", \"Parâmetros\", \"Parâmetros\", \"Gravar\", \"ppaParametrosHome\", \"persist\", TipoAcessoBean.ACAO));\n" + 
        "acessos.add(new AcessoBean(\"Ferramentas\", \"Parâmetros\", \"Parâmetros\", \"Atualizar Dados\", \"ppaParametrosHome\", \"update\", TipoAcessoBean.ACAO));\n" + 
        "acessos.add(new AcessoBean(\"Ferramentas\", \"Parâmetros\", \"Parâmetros\", \"Leitura\", \"ppaParametrosHome\", \"find\", TipoAcessoBean.ACAO));\n" + 
        "acessos.add(new AcessoBean(\"Ferramentas\", \"Parâmetros\", \"Parâmetros\", \"Excluir\", \"ppaParametrosHome\", \"remove\", TipoAcessoBean.ACAO));";

    public static void main( String[] args ) {

        int[] maxWidth = new int[1024];

        String[] lines = input.split( "\n" );
        List<String[]> output = new ArrayList<String[]>();
        for( String line : lines ) {
            String[] columns = line.split( "\\s*,\\s*" );
            output.add( columns );

            int i = 0;
            for( String column : columns ) {
                maxWidth[i] = Math.max( maxWidth[i], column.length() );
                i ++;
            }
        }

        for( String[] columns : output ) {
            int i = 0;
            String delim = "";
            for( String column : columns ) {
                System.out.print( delim );
                delim = ", ";

                String format = String.format("%%-%ds", maxWidth[i]);
                System.out.printf( format, column );

                i ++;
            }

            System.out.println();
        }
    }
}