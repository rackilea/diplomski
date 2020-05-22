<ui:style type="com.yourapp.YourClass.MyStyle">     
    .testStyle {
    }
    .styleRequiredData
    {
        color:red;
    }
</ui:style>

public class YourClass extends Widget {
    interface MyStyle extends CssResource {
        String testStyle();
        String styleRequiredData();
    }

    @UiField MyStyle style;

    /* ... */

    @UiHandler("comboTitle")
    void onComboTitleBlur(BlurEvent event) {
        int title = comboTitle.getSelectedIndex();
        if(title == 0){
            labTitleReq.setText("Please enter a value");
            labTitle.getElement().addClassName(style.styleRequiredData);
        } else {
            labTitleReq.setText("");
        }
    }
}