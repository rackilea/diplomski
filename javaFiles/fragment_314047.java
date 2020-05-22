public class FormulaService {
    public boolean validateFormula(String formula) {

        boolean validFormula = true;
        double result = 0;

        try {
            result = methodThatCalculatAFormula(formula, 10, 10);
        } catch (Exception e) {
            validFormula = false;
        }

        if (result == 0)
            validFormula = false;
        return validFormula;
    }

    public  double methodThatCalculatAFormula(String formula, int i, int j){
        return 0;
    }
}