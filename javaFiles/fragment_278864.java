public class HelloApplication extends Application {
        private int globalVariable=1;

        public int getGlobalVariable() {
                return globalVariable;
        }

        public void setGlobalVariable(int globalVariable) {
                this.globalVariable = globalVariable;
        }
        @Override
        public void onCreate() {
                //reinitialize variable
        }
}