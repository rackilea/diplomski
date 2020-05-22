private String text;

// here you will update the input text - in your case method which does calculations
    public void changeText(){
        ...
        text = "updated"; 
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }