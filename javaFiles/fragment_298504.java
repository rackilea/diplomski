String[] getAnswerIds = new String[]{"1","4","16","18","20"};
    boolean after_first = false;
    StringBuilder sb = new StringBuilder();
    for (String s: getAnswerIds) {
        if (after_first) {
            sb.append(",");
        } else {
            after_first = true;
        }
        sb.append(s);
    }
    String your_list_of_values = sb.toString();