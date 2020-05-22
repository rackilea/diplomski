makeEditable(
{
  sUpdateURL: function(value, settings)
  {
    var sentObject = {}
    var rowId = oTable.fnGetPosition(this)[0];
    var columnPosition = oTable.fnGetPosition(this)[1];
    var columnId = oTable.fnGetPosition(this)[2];
    var sColumnTitle = oTable.fnSettings().aoColumns[columnId].sTitle; 
    sentObject["rowid"]= rowId
    sentObject["columnpos"]= columnPosition
    sentObject["columnId"]= columnId
    sentObject["sColumnName"]= sColumnTitle
    sentObject["valueOfCell"]=value
    sentObject["Serial"]="serialnumber"
    sentObject["Hourly"]="somevalue"
    $.ajax({
    type: "POST",
    url: "url",
    data: "sentObj="+JSON.stringify(sentObject)
    })
    return value;
  },
  sSuccessResponse: "IGNORE"
 }
);