public void toggleCheckAll() {

        isCheckAll = !isCheckAll;

        for (int i = 0; i < listData.size(); i++) {
            if (isCheckAll) {
                checkBoxState[i] = true;
                notifyDataSetInvalidated();
            } else {
                checkBoxState[i] = false;
                notifyDataSetInvalidated();
            }
        }
    }