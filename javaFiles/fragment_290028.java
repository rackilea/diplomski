public class Policy {
   double amount;
   public int policyCount;
   public static int policyNumber = 0;

   private int myPolicyNumber;

   public Policy(double a){
    amount = a;
    myPolicyNumber = policyNumber;
    policyNumber ++;

   //or even better
   //myPolicyNumber = ++policyNumber;

  }
}