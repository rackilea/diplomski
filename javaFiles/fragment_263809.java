if (querySelectRegexp !== undefined) {

                    if (queryRegexp !== undefined) {
                        if (row.name.match(queryRegexp)) {
                            row.classes = row.classes.replace(/hide/g, "");
                        } else {
                            if (row.classes.indexOf("hide") === -1) {
                                row.classes += " hide";
                            }
                        }
                    } else if (querySelectRegexp !== undefined) { (row.type.match(querySelectRegexp)) {
                            row.classes = row.classes.replace(/hide/g, "");
                        } else {
                            if (row.classes.indexOf("hide") === -1) {
                                row.classes += " hide";
                            }
                        }
                    } else {
                        row.classes = row.classes.replace(/hide/g, "");
                    }