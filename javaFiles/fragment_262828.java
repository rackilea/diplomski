import android.view.View;
import android.widget.RadioButton;

/**
 * <p>
 *     CREATED:<br />&nbsp;&nbsp;&nbsp;&nbsp;
 *          15 Aug 2015
 * </p>
 * <p>
 *     This class is created to make a RadioGroup
 *     with no limitation of designing and layouting.
 *  <br />
 *  <strong>
 *      The first method you have to call is
 *      <em>createRadioGroup ()</em> to
 *      initialize your RadioGroup.
 *  </strong>
 *  <br />
 *     Feel free to browse in the class
 *     and making change in it as you need.
 * </p>
 * @author ShahinSorkh
 * @version 1
 */
public class RadioGroup2 {

// Global variables
private RadioButton rb [];
private int firstCheckedItemId;
public static int countRadioButtons;

/**
 * <p>
 *     will initialize your RadioGroup
 * </p>
 * <p>
 *     <strong>an example:</strong>
 *     <p>
 *         RadioGroup2 rg = new RadioGroup2;<br />
 *         RadioButton rb [] = new RadioButton[3];<br />
 *         rb[0] = (RadioButton)findViewById(R.id.radio1);<br />
 *         rb[1] = (RadioButton)findViewById(R.id.radio2);<br />
 *         rb[2] = (RadioButton)findViewById(R.id.radio3);<br />
 *         rg.createRadioGroup(rb);
 *     </p>
 * </p>
 * @param radioButtons an Array of RadioButtons
 */
public void createRadioGroup(RadioButton [] radioButtons){
    rb = radioButtons;
    firstCheckedItemId = getCheckedItemId();
    countRadioButtons = rb.length;
    onCheck();
}

private void onCheck(){
    for (RadioButton aRb : rb) {
        aRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View radio) {
                final RadioButton myRb = (RadioButton) radio;
                for (RadioButton aRb : rb) {
                    if (aRb.getId() == myRb.getId()) {
                        aRb.setChecked(true);
                    } else aRb.setChecked(false);
                }
            }
        });
    }
}

/**
 * will count RadioButtons in your RadioGroup
 * @return the count of RadioButtons in RadioGroup
 */
public int getRadioButtonsCount(){
    return countRadioButtons;
}

/**
 * <p>
 *     will return the checked item <strong>ID</strong>
 *     <em>you can use in findViewById() for example</em>
 * </p>
 * <p>
 *     will return <em>-1</em> if no RadioButton has checked<br />
 *     better to check if any button has checked
 * </p>
 * @return int checkedRadioButtonId
 */
public int getCheckedItemId (){
    int id = -1;
    for (RadioButton aRb : rb) {
        if(aRb.isChecked())
            id = aRb.getId();
    }
    return id;
}

/**
 * <p>
 *     will return the checked <strong>RadioButton</strong>
 * </p>
 * <p>
 *     will return <em>null</em> if no RadioButton has checked<br />
 *     better to check if any button has checked
 * </p>
 * @return checked RadioButton directly
 */
public RadioButton getCheckedItem (){
    RadioButton RB = null;
    for (RadioButton aRb : rb) {
        if(aRb.isChecked())
            RB = aRb;
    }
    return RB;
}

/**
 * will reset all RadioButtons checked state
 * to default, all RadioButtons will unCheck
 * and the firstChecked RadioButton will check
 * at end
 */
public void resetButtons(){
    RadioButton iRb = getCheckedItem();
    if(iRb != null)
        iRb.setChecked(false);
    if(firstCheckedItemId != -1)
        getChildById(firstCheckedItemId).setChecked(true);
}

private RadioButton getChildById(int id){
    RadioButton iRb = null;
    for (RadioButton aRb : rb ) {
        if(aRb.getId() == id) {
            iRb = aRb;
            break;
        }
    }
    return iRb;
}

/**
 * <p>
 *     will return <strong>RadioButton</strong> at given index in the Array
 * </p>
 * @param position index of RadioButton in Array
 * @return RadioButton[i]
 */
public RadioButton getChildAt (int position){
    return rb[position];
}
}