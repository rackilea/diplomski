for(int i=3; i<filteredSubGroupList .length(); i++){
                try {
                    filteredSubGroupList = (ProgramMethod.filterArray(subGroupList, "main-group-nr", String.valueOf(3), false));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }