public boolean verify(JComponent input) {
        String name = input.getName();

        if(name.equals("tf1"))
        {
            String text = ((JTextField) input).getText().trim();
            if (text.isEmpty()) return false;
            if (text.matches(".*\\d.*")) return false;
        }
        if(name.equals("tf2"))
        {
            //other condition
            return true;
        }

        return true;
    }