//first if statement
if(rClass.equals("SavingsAccount")) {
    account = new SavingsAccount(rId,rName,start, end);
}

//second if statement
if(rClass.equals("DraftAccount")) {
    account = new DraftAccount(rId,rName,start, end);
}

//And an if-else
if(rClass.equals("VIPAccount")) {
    account = new VIPAccount(rId,rName,start, end);
}
else {
    account = null;
}