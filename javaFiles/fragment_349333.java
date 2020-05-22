String evalStr;
 String messageStr = "<html><p style=\"font-size:95%\">";

 evalStr = "(find-all-facts ((?f technique)) TRUE)";

 MultifieldValue mv = (MultifieldValue) clips.eval(evalStr);
 int tNum = mv.size();

 for (int i = 1; i <= tNum; i++)
   {
    evalStr = "(find-fact ((?f technique-employed)) " +
                   "(eq ?f:priority " + i + "))";

    mv = (MultifieldValue) clips.eval(evalStr);
    if (mv.size() == 0) continue;

    FactAddressValue fv = (FactAddressValue) mv.get(0);

    messageStr = messageStr + ((NumberValue) fv.getFactSlot("priority")).intValue() + ". " +
                              ((LexemeValue) fv.getFactSlot("reason")).lexemeValue() + "<br>";
   }
JOptionPane.showMessageDialog(jfrm,messageStr,sudokuResources.getString("SolutionTechniques"),JOptionPane.PLAIN_MESSAGE);