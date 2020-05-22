group.setData(new String(group.getText()));

    group.addPaintListener(new PaintListener() {

        @Override
        public void paintControl(PaintEvent e) {
            if (e.widget instanceof Group) {
                Group grp = (Group)e.widget;
                String data = (String)grp.getData();
                if (!data.equals(grp.getText())) {
                    System.out.println("Title changed");
                    grp.setData(grp.getText()); //Keep new changed title as data
                }
            }

        }
    });