public Response run(Request req){
long lasttime=Sys.getTime();
int i=0;
while(i<10){
   if(Response res = runImpl(req);){
   return response;
   }
   if((Sys.getTime-lasttime)>1000){
   i++;
   lasttime=Sys.getTime();
   }
}
return null;