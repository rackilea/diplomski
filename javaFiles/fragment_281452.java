@Resource
private SessionContext ctx;

//and then in method
if(fail) {
    ctx.setRollBackOnly(); 
}