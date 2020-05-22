// Turn off drawing to avoid flicker
       t.setRedraw(false);
        for (Indicator ind : indicators) {
            TreeItem item = new TreeItem(t, SWT.None);
            item.setText(ind.getNumber() + " " + ind.getName());
            item.setData(ind);
            // create sub elements
            for (SubIndicator subInd : ind.getSubIndicators()) {
                TreeItem child = new TreeItem(item, SWT.None);
                child.setText(subInd.getNumberString() + " " + subInd.getName());
                child.setData(subInd);
            }
        }
        // this one I forgot
        t.setRedraw(true);