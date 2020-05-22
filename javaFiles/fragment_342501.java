public class Main {
    public static void main(String[] args) {
        ModuleGrader mg=new ModuleGrader();
        System.out.println(mg.gradeModule(100));
        System.out.println(mg.gradeModule(66));
    }
    public static class ModuleGrader {
        final int examID = 123;
        String excellent = null;
        String good = null;
        String satisfactory = null;
        String compensatableFail = null;
        String outrightFail = null;
        int grade;

        public String gradeModule(int mark) {
            String result = null;
            if (mark >= 70 && mark <= 100) {
                result = excellent;
                System.out.println(" ");
            } else if (mark >= 60 && mark <= 69) {
                result = good;
            } else if (mark >= 50 && mark <= 59) {
                result = satisfactory;
            } else if (mark >= 40 && mark <= 49) {
                result = compensatableFail;
            } else if (mark >= 0 && mark <= 39) {
                result = outrightFail;
            } else {
                System.out.println("Invalid entery, please insert an number between 100-0");
            }

            return result;
        }
    }
}