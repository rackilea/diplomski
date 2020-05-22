public void cbxSalesSelectA() {
    boolean t = cbx_SALES_Select_All.getText().equals("Select All");
    allSetSelected(t, cbx_SALESQtySold,
                      cbx_SALESDateSold,
                      cbx_SALESCustomer,
                      cbx_SALESDiscount,
                      cbx_SALESLineNumber,
                      cbx_SALESConsultant,
                      cbx_SALES_Header_Row)
    if (t) {
        cbx_SALES_Select_All.setText("Deselect All");
    } else {
        cbx_SALES_Select_All.setText("Select All");
    }
}

public void cbxLOCSelectA() {
    boolean t = cbx_LOC_Select_All.getText().equals("Select All");
    allSetSelected(t, cbx_LOCHeight, cbx_LOCWidth, cbx_LOCDepth, cbx_LOCWeightCap, cbx_LOCAccessibility, cbx_LOC_Header_Row);
    if (t) {
        cbx_LOC_Select_All.setText("Deselect All");
    } else {
        cbx_LOC_Select_All.setText("Select All");
    }
}