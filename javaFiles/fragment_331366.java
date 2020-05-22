public Response run(Request req){
long lasttime=Sys.getTime();
int i=0;
for(int i; i<(10000/yourchoiceinterval); i++){
   if(Response res = runImpl(req);){
   return response;
   }
   if((Sys.getTime-lasttime)>1000){
   lasttime=Sys.getTime();
   }
}
return null;