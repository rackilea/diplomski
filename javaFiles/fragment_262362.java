FormData formData = new FormData();
// Fix the left edge of the control to 25% of the overall width + 10px offset.
formData.left = new FormAttachment(25, 10);
// Fix the lower edge of the control to 75% of the overall height + 0px offset.
formData.bottom = new FormAttachment(75);
// Tell the control its new position.
control.setLayoutData(formData);