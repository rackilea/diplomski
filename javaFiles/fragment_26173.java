if(rClass.equals("SavingsAccount")) {
    account = new SavingsAccount(rId,rName,start, end);
}else if(rClass.equals("DraftAccount")) {
    account = new DraftAccount(rId,rName,start, end);
}else if(rClass.equals("VIPAccount")) {
    account = new VIPAccount(rId,rName,start, end);
}else {
    account = null;
}