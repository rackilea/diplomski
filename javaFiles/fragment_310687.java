import static com.google.common.base.Strings.isNullOrEmpty;
...
import com.documentum.dmcl.impl.DmclApi;
...

public class MyBofClass extends MyBofInterface {
    ...

    private boolean execSql(String sql) throws DfException {
        return execApi("execsql", sql);
    }

    private boolean execApi(String command, String args) throws DfException {
        return execApi(getSession(), command, args);
    }

    private boolean execApi(IDfSession session, String command, String args) throws DfException {
        StringBuilder apiBuilder = new StringBuilder(command);
        apiBuilder.append(',');
        apiBuilder.append(session.getSessionId());
        if (!isNullOrEmpty(args)) {
            apiBuilder.append(',');
            apiBuilder.append(args);
        }
        return DmclApi.getInstance().exec(apiBuilder.toString());
    }
    ...
}