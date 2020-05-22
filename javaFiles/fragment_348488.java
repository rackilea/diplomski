JCheckBox[] jcb = limitPane.getChecks();
for (JCheckBox cb : jcb) {
    cb.setSelected(false); //...
}
for (JCheckBox cb : jcb) {
    cb.getParent().remove(cb); //...
}