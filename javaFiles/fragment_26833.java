class PageScreen{
    String labelField;

    public void setLabelField(String labelField){
        this.labelField = labelField;
    }

    public String getLabelField(){
        return labelField;
    }
}

class TestScreen extends PageScreen{
    public String getLabelField(){
        return super.getLabelField();
    }
}