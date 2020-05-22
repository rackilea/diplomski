JRDesignTextField text; // This text field is from the new jasper report file
JasperDesign jasperDesign; //This is from master template that has all info

text.setFontName("ColumnHeadingFont");
List<JRStyle> stylesList = jasperDesign.getStylesList();
for(JRStyle st : stylesList){
if("ColumnHeadingFont".equals(st.getFontName()))
{
    text.setFontSize(st.getFontsize());
    break;
}
}