function (doc, meta) {

  if(doc._class == "package.model.ContentDoc") {
    for(var i=0; i < doc.contributors.length; i++){
         emit(doc.contributors[i].id, null);
    }

  }
}