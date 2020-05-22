public class ComboValues {
    public Vector getValues(Input i){
        Vector v = new Vector<String>();
        if(i.getInput()==0)
            v.add("worked");
        else
           v.add("it hurts");
        return v;
    }
}