import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;

class Test {
    public static void main(String[] args){
        CloneCommand clone = Git.cloneRepository().setURI(uri).setDirectory(new File(checkoutDir));
        try {
            clone.call();
        } 
        catch (GitAPIException e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}