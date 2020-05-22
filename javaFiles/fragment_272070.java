function populateWoodId(){
    var selectBox = document.getElementById('woodType');

    /* selected value of dropdown */
    var woodProp = selectBox.options[selectBox.selectedIndex].value;

    /* selected value set to input field */
    var splitVal=woodProp.split("#",5);
    document.getElementById('woodHeight').value = splitVal[0]; 
    document.getElementById('woodHeight1').value = splitVal[1]; 
    document.getElementById('woodHeight2').value = splitVal[2]; 
    document.getElementById('woodHeight3').value = splitVal[3]; 
    document.getElementById('woodHeight4').value = splitVal[4]; //five different textboxes

}