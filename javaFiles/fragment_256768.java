public void actionPerformed(ActionEvent e) {
        // index--;       THIS ONE WORKED, OF COURSE
        // lbIndex.setText(index + "");

        // BUT THIS ONE DIDNT, PLEASE EXPLAIN FOR ME
        int i = getIndex();
        setIndex(--i);
        lbIndex.setText(index + "");
    }