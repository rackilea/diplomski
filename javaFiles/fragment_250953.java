package netElements;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;

public class Valve implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 6425822395370778513L;
    protected int valveNumber;
    protected String valveName;
    private transient mxStylesheet valveStyleSheet;
    private mxCell _valveCell;
    private double _valveX, _valveY, valveRotationalAngle=0;
    protected String valveStyleName, valveStyleString="";

    public Valve() 
    {   
    }

    public void setValveNumber(int elementNumber) {
        // TODO Auto-generated method stub
        valveNumber=elementNumber;

    }

    public int getValveNumber() {
        // TODO Auto-generated method stub
        return valveNumber;
    }

    public void setValveStyleName(String styleName) {

        valveStyleName=styleName;
    }

    public String getValveStyleName() {

        return valveStyleName;
    }

    public void setValveStyle(mxGraph g) {

        Map<String, Object> transProperties;

        valveStyleSheet = g.getStylesheet();
        transProperties = new HashMap<String, Object>();
        transProperties.put(mxConstants.STYLE_SHAPE, "valve");
        transProperties.put(mxConstants.STYLE_STROKECOLOR, "black");
        transProperties.put(mxConstants.STYLE_ROTATION, valveRotationalAngle);
        transProperties.put(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_TOP);
        valveStyleSheet.putCellStyle(valveStyleName, transProperties);

        this.setValveStyleString(transProperties);

    }

    public mxStylesheet getValveStyle() {

        return this.valveStyleSheet;
    }

    public void setValveStyleString(Map<String, Object> transProperties) {

        transProperties.entrySet().stream().forEach(entry ->
        valveStyleString+=entry.getKey()+"="+entry.getValue().toString()+";");
    }

    public String getValveStyleString() {

        return valveStyleString;

    }

    public void setValveRotationalAngle(double angle) {
        // TODO Auto-generated method stub
        valveRotationalAngle=angle;

    }

    public double getValveRotationalAngle() {
        // TODO Auto-generated method stub
        return valveRotationalAngle;
    }


    public void setValveName(String elementName) {
        // TODO Auto-generated method stub
        valveName=elementName;

    }

    public String getValveName() {
        // TODO Auto-generated method stub
        return this.valveName;
    }

}