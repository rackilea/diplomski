boolean isSearchValue = true;


    for (Field formFieldValMap : fieldList) {
                if (formFieldValMap.getIsSearchableField().equals("0")) {

                    isSearchValue = false;
                    return;
                } 
            }