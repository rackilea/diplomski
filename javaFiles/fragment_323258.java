private void clearcheck(){        
        if(q.trim() != null || q.trim() != ""){
            questionView.setText(q);
            r1.setChecked(false);
            r2.setChecked(false);
            r3.setChecked(false);

            r1.clearFocus();
            r2.clearFocus();
            r3.clearFocus();

            r1.setText(varNames.get("ra0"));
            r2.setText(varNames.get("ra1"));
            r3.setText(varNames.get("ra2"));
        }
}