public class test {

    public static void main(String[] args) {
        double []perturb={0.},params={1.2E-7};
        double h=1.2E-10;
        int i=0;
        perturb[i] = params[i]-h;
        System.out.println("    params "+Double.toString(params[i])+"\n");
        System.out.println("    h      "+Double.toString(h)+"\n");
        System.out.println("    pert1  "+Double.toString(params[i]-h)+"\n");
        System.out.println("    pert2  "+Double.toString(perturb[i])+"\n");

    }
}