public AccessibleText getAccessibleText() {
            View view = (View)JLabel.this.getClientProperty("html");
            if (view != null) {
                return this;
            } else {
                return null;
            }
        }