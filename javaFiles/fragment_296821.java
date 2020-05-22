concatenacion = "(_id||' '||Desc_art||' '||Nom_proveedor||' '||marca) like '"+resultado+"'" +
            "OR (_id||' '||Nom_proveedor||' '||marca||' '||Desc_art) like '"+resultado+"'" +
            "OR (marca||' '||Nom_proveedor||' '||Desc_art||' '||_id) like '"+resultado+"'" +
            "OR (marca||' '||Nom_proveedor||' '||_id||' '||Desc_art) like '"+resultado+"'" +
            "OR (Desc_art||' '||Nom_proveedor||' '||marca||' '||_id) like '"+resultado+"'" +
            "OR (Desc_art||' '||_id||' '||Nom_proveedor||' '||marca) like '"+resultado+"'";