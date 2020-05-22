function selectAllCheckboxes(checkboxElement) {
    var allFormElements = checkboxElement.form.elements;
    for (var i = 0; i < allFormElements.length; i++) {
        var formElement = allFormElements[i];
        if (formElement.name.indexOf('mform_content_ABoxes_') == 0) { // Check if its name starts with particular string.
            formElement.checked = checkboxElement.checked;
        }
    }
}