boolean foundDup = false;
 for (int p = 0; p < rowItems.size(); p++) {

                // if the version id is equal to any of the others already in the rowItems array appent the name to the object already in the array
                if (item.getVersionId().toString().equals(rowItems.get(p).getVersionId().toString()))
                {
                    rowItems.get(p).setName(item.getName().toString() + "\n<ToSeeEndOfLine>" + rowItems.get(p).getName().toString()); // EDIT: this line is changed
                    foundDup = true;
                    break;
                } 
            }
     if (!foundDup)
            rowItems.add(item);