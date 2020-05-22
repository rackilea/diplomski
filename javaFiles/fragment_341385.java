protected void setValue(Object element, Object value) 
{
    if((element instanceof AplotDatasetData) && (value instanceof Integer)) {
        Integer choice = (Integer)value;

        String option = ((AplotDatasetData)element).getMarkupValue();

        if(choice == 0) {
            option = "No";
        }    
        else if(choice == 1) {
            option = "Yes";
        }    
        else {
            option = "Both";

            // create a copy of your element
            // add it to your model
            // update the viewer
        }

        getViewer().update(element, null);
    }

}