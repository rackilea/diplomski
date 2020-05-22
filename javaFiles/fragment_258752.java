class person
{
        public PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);

        private String firstName;
        private String middleName;
        private String lastName;
        private int gender;
        private Integer age;
        .
        .

        set Fname(String firstName)
        {
                      propertyChangeSupport.firePropertyChange("firstName",this.firstName,this.firstName         = firstName);
        }
        .
        .
        .
        public void setPropertyChange(PropertyChangeSupport propertyChange) {
                this.propertyChange = propertyChange;
        }


         public PropertyChangeSupport getPropertyChange() {
                return propertyChange;
         }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChange.removePropertyChangeListener(listener);
        }

}