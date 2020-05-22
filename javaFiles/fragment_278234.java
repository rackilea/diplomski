int maxsize = mmPageCounter.equalsIgnoreCase("true") ? 10 : acctIdList.size();

if(mmPageCounter.equalsIgnoreCase("false")){
    if(whatPageNext.equalsIgnoreCase("alwaysFirst"))    
        accountListSize = accountListSize = acctIdList.size();
} else {
  accountListSize = whatPageNext.equalsIgnoreCase("first") ? 5 : maxsize
}