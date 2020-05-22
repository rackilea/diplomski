import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "bean")
@SessionScoped
public class TestBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<String> dummyNames;
    private String selectedName;
    private List<String> inputTexts;

    public TestBean() {
        dummyNames = new ArrayList<String>();
        dummyNames.add("AK");
        inputTexts = new ArrayList<String>();
        inputTexts.add("");

    }

    public void addInput(ActionEvent e) {
        if (inputTexts.size() == 5) {
            System.out.println("excedded limit");
            return;
        }
        inputTexts.add("");

    }

    public List<String> getDummyNames() {
        return dummyNames;
    }

    public void setDummyNames(List<String> dummyNames) {
        this.dummyNames = dummyNames;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }

    public List<String> getInputTexts() {
        return inputTexts;
    }

    public void setInputTexts(List<String> inputTexts) {
        this.inputTexts = inputTexts;
    }

}