package code;

import java.util.ArrayList;
import java.util.List;

class ProjUtils
{

   int noSteps;
   String testName = "";
   String DMS;
   String appL;
   String func;
   String subFunc;
   String desc = "";
   String regPriority = "High||Medium||Low";
   String type = "Manual||Automated";
   List<String> stepNameList = new ArrayList<>();
   List<String> stepDescList = new ArrayList<>();
   List<String> expResList = new ArrayList<>();
   int counter = 1;
   int caseCounter = 1;

   public void preDefSteps()
   {


      System.out.println("Enter number of predefined steps:");

      String stName = null, stDesc = null, expResu = null;

      try
      {

         noSteps = Integer.valueOf(br.readLine());
         int i = 0;

         while (i < noSteps && br.readLine() != null)
         {

            br.readLine();

            System.out.println("Step Name:\n");
            stName = br.readLine();
            System.out.println("Step Descripiton:\n");
            stDesc = br.readLine();
            System.out.println("Expected Result:\n");
            expResu = br.readLine();
            br.readLine();
            System.out.println(stName + "\n" + stDesc + "\n" + expResu);
            stepNameList.add(stName);
            stepDescList.add(stDesc);
            expResList.add(expResu);

            i++;
       [...]
}