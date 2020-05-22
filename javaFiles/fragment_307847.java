class ProvaSingleton{

   private static ProvaSingleton instance = null;

   private Integer prova;

   private ProvaSingleton(){
      prova = 2;
   }

   public static ProvaSingleton getInstance(){

      if (instance == null){
          instance = new ProvaSingleton();
      }
      return instance;
   }

   public Integer getProva(){ return this.prova;}

   public void setProva(Integer p){this.prova = p;}
}