ArrayList<R4NPoint> arrList = new ArrayList<R4NPoint>() {{
            add(new R4NPoint(0, 0));
            add(new R4NPoint(3, 0));
            add(new R4NPoint(5, 2));
            add(new R4NPoint(7, 4));
            add(new R4NPoint(9, 6));
            add(new R4NPoint(5, 0));
            add(new R4NPoint(10, 4));
            add(new R4NPoint(15, 8));
        }};

        // start at the second item as our check is always dependent on our previous and next neighbors
        int index = 1;
        int totalSize = arrList.size();
        for (int numberOfItemsChecked = 1; numberOfItemsChecked < totalSize - 1; numberOfItemsChecked++) {
            int prevIndex = index - 1;
            int nextIndex = index + 1;
            // check previous and next for removal condition
            if (arrList.get(index).arePointsColinear(arrList.get(prevIndex), arrList.get(nextIndex))) {
                // if they are co-linear remove the item at our current index, and don't increment the index
                // the next item will now be at the current index
                arrList.remove(index);
            } else {
                index++;
            }
        }
        System.out.println("finalArrayAfterRemoval = " + arrList.toString());