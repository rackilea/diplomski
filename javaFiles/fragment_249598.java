public enum PossibleInterfacesEnum {
    INTERFACE_1 {
        public javax.swing.JPanel getInstance() {
            return new javax.swing.JPanel();
        }
    },
    INTERFACE_2 {
        public javax.swing.JPanel getInstance() { 
            return new javax.swing.JPanel();
        }
    };

    public abstract javax.swing.JPanel getInstance();
}