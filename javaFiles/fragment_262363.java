FormData formData = new FormData();
// Fix left edge 10px to the right of the right edge of otherControl
formData.left = new FormAttachment(otherControl, 10, SWT.RIGHT);
// Fix bottom edge at exactly the same height as the one of otherControl
formData.bottom = new FormAttachment(otherControl, 0, SWT.BOTTOM);
control.setLayoutData(formData);