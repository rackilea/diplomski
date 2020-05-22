@ViewScoped
    @ManagedBean(name="clockBean")
   public class clockBean implements Serializable{

        private  int number;

        public void increment(){
           number++;
        }

        public int getNumber() {
          return number;
        }

        public void setNumber(int number) {
          this.number = number;
        }
}