String queryParam;

@Init
public void init(@QueryParam("parameter") int parm1){
    queryParam = parm1;

}