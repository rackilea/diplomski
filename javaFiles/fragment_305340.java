bool Appended = false;
for (String value : list) {
                    if(Appended) { filterval += " ";}
                    filterval += checkForDataHolder(value) + ",";
                    Appended = true;
                }