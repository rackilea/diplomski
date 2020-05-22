import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

        String src =
                "    EVALUATE WS-ADDITIONAL-FILE-WORK                           \n" +
                "            WHEN \"ACCNT\"                                     \n" +
                "                IF LINK-TRIG-FILE-NAME NOT = \"ACTMSTR   \"    \n" +
                "                PERFORM 04510-GET-ACCOUNT-MASTER               \n" +
                "                ELSE                                           \n" +
                "                MOVE \"0106H\"             TO WS-ERROR-CODE    \n" +
                "                PERFORM 09000-PROCESS-ABORT-ERROR              \n" +
                "                END-IF                                         \n" +
                "             WHEN \"ADDRM\"                                    \n" +
                "                 IF LINK-TRIG-FILE-NAME NOT = \"ADDRMSTR  \"   \n" +
                "                 IF PROGRAM-HBMS-RELEASE (1:3) > \"5.0\"       \n" +
                "                   PERFORM 04520-GET-ADDRESS-MASTER            \n" +
                "                 END-IF                                        \n" +
                "                 ELSE                                          \n" +
                "                   MOVE \"0106H\"        TO WS-ERROR-CODE      \n" +
                "                 PERFORM 09000-PROCESS-ABORT-ERROR             \n" +
                "                 END-IF                                        \n" +
                "             WHEN OTHER                                        \n" +
                "                 MOVE \"0106F\"             TO WS-ERROR-CODE   \n" +
                "                 PERFORM 09000-PROCESS-ABORT-ERROR             \n" +
                "    END-EVALUATE.                                                ";

        Matcher m = Pattern.compile("EVALUATE(\"[^\"]*\"|((?!EVALUATE|END-EVALUATE)[^.\"])+)*(END-EVALUATE|\\.)").matcher(src);

        while(m.find()) {
            System.out.println(m.group());
        }
    }
}