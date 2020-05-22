Transaction obj = transactionList.get(position);

    if (obj.typeToDisp == 0) {
        return TYPE_LOAD_TRANS;
    } else if (obj.typeToDisp == 1) {
            return TYPE_LOAD_TRANS_DETAIL;
        }

    return super.getItemViewType(position);