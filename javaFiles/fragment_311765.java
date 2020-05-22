class ExampleBean
{

    ExampleBean()
    {
        this.elements = new String[10];
    }

    private String[] elements;

    // standard getters and setters for non-indexed access. Comment the lines in the double curly brackets, to have getPropertyType return null.
    // {{ 
    public String[] getElements()
    {
         return elements;
    }

    public void setElements(String[] elements)
    {
         this.elements = elements;
    }
    // }}

    // indexed getters and setters
    public String getElements(int index) {
        return this.elements[index];
    }

    public void setElements(int index, String[] elements)
    {
         this.elements[index] = elements;
    }

}