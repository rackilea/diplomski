label.setText(Integer.toString(number_of_boxes_checked));
    if (number_of_boxes_checked > 6) {
        for (int i = 0; i < 30; ++i) { //<- your bug was here, I fixed it
            checkBox[i].setEnabled(false);
        }
    } else {
        ++number_of_boxes_checked;
   }