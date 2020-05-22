$.each(data.result, function(listID, mapData){
     /* I am assuming you will create Lable for each String in JSON inside your HTML */
    $("#displaySearchResults > idLable").text(mapDate.id);
    $("#displaySearchResults > nameLable").text(mapDate.name);
    $("#displaySearchResults > urlLable").text(mapDate.url);

}