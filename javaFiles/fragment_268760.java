public boolean compareLists(List<MyData> prevList, List<MyData> modelList) {
        if (prevList.size() == modelList.size()) {
            for (MyData modelListdata : modelList) {
                for (MyData prevListdata : prevList) {
                    if (prevListdata.getName().equals(modelListdata.getName())
                            && prevListdata.isCheck() != modelListdata.isCheck()) {
                        return  true;

                    }
                }

            }
        }
        else{
            return true;
        }
        return false; 

    }