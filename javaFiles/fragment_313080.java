for(CTPivotField ctPivotField:pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldList()){
            ctPivotField.setAutoShow(false);
            ctPivotField.setOutline(false);
            ctPivotField.setSubtotalTop(false);
            ctPivotField.setSubtotalCaption("");
        }