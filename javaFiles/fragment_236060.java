private List<String> optionList;
private String selectedOption;

public String getSelectedOption() {
   return selectedOption;
}
public void setSelectedOption(String selectedOption) { 
   this.selectedOption = selectedOption;
}
public List<String> getOptionList() {
   return optionList;
}
public void setOptionList(List<String> optionList) {
   this.optionList = optionList;
}

@Init
public void init() {
    List<String> entries = new ArrayList<String>();
    entries.add("a");
    entries.add("b");
    setOptionList(entries);
}