String abc = "";
boolean isThis = accountType.equals("something");
for(ReportJDO reportJDO : reportJDOList) {  
    abc = isThis ? reportJDO.getThis() : reportJDO.getThat();
    //somecode goes here
}