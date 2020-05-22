public class PageIndex extends FlowPanel{

    private ProvaUtility utility;

    private PageCenter center;

    public PageIndex(ProvaUtility pu){

        this.utility = pu;
        this.center = new PageCenter(pu);
        this.add(this.center);
    } 

    public Integer getProva(){
         return this.utility.getProva();
     }
}

 public class PageCenter extends FlowPanel{

    private ProvaUtility utility;

    public PageCenter(ProvaUtility u){
       this.utility = u;
       this.utility.setProva(2);
    }
 }