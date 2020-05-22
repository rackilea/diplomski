import javax.swing.InputVerifier;
import javax.swing.JComponent;

public class CombinedInputVerifier extends InputVerifier {

    private InputVerifier[] verifiers;

    public CombinedInputVerifier(InputVerifier... verifiers) {
        this.verifiers = verifiers;
    }

    @Override
    public boolean verify(JComponent input) {
        for (InputVerifier verifier : verifiers) {
            if (!verifier.verify(input)) {
                return false;
            }
        }
        return true;
    }

}