for (String value : list) {

                    filterval += checkForDataHolder(value) + ", ";
                }

if (filterval.indexOf(",") != -1) {
                        filterval = filterval.substring(0, filterval
                                .lastIndexOf(","));
                    }