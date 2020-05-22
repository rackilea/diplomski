public boolean compareLists(List<MyData> prevList, List<MyData> modelList) {
        if (prevList!= null && modelList!=null && prevList.size() == modelList.size()) {
            boolean indicator = false;
            for (MyData modelListdata : modelList) {
                for (MyData prevListdata : prevList) {
                    if (prevListdata.getName().equals(modelListdata.getName())
                            && prevListdata.isCheck() != modelListdata.isCheck()) {
                        return  true;

                    }
                    if (modelListdata.getName().equals(prevListdata.getName())) {
                        indicator = false;
                        break;
                    } else
                        indicator = true;
                }
                }

            }
        if (indicator)
            return true;
    }
        }
        else{
            return true;
        }
        return false; 

    }