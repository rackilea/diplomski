for(BT_item item:questionPool){ // loop through all the items in the question pool
        String level = BT_strings.getJsonPropertyValue(item.getJsonObject(), "Level", "");
        if(level.equals(String.valueOf(count+1))) {
            childItems.add(item); // add 1 to count because it starts at 0, but levels start at 1
            break; // found a question, so break the inner loop (but not the outer one)
        }
    }