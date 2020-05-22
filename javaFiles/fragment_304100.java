function soumettreRapport() {

    var jsonArray = ${jsonArrayString};

    creerRapport( "${current.title}",
                  "${current.type}",                                    
                   ${current.width},
                   ${current.height}, jsonArray );

}