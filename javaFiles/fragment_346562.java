function modify(){
    var textBox = document.getElementById('editableTextBox');//text box name
    var newName = document.getElementById('editableTextBox').value;
    if(textBox!=null){
        var table = document.getElementsByTagName("table");
        var rows = table[3].rows;
        var rowCount=0;
        for(i=1;i<rows.length;i++){
            rowCount = i;
            var cells = rows[i].cells;

                     if(cells[1].hasChildNodes()){
           var nodeName = cells[1].childNodes[0].nodeName;
          if(nodeName=="INPUT"){
            break;
           }
        }
    }
    var reqCell =rows[rowCount].cells[cells.length-2];
    var oldLink = reqCell.childNodes[1].getAttribute("href"); //getOld link
    reqCell.childNodes[1].setAttribute("href",oldLink+"&newName="+newName)  //set href with appending text box value
}
}