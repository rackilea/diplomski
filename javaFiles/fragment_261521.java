// two panels as placeholders
    JPanel northPanel = new JPanel();
    northPanel.setBackground(Color.YELLOW);
    JPanel southPanel = new JPanel();
    southPanel.setBackground(Color.YELLOW);
    // layout with two content columns
    LC layoutContraints = new LC().wrapAfter(2)
            .debug(1000);
    AC columnContraints = new AC()
    // first column pref, followed by greedy gap
            .size("pref").gap("push")
            // second
            .size("pref");
    // three rows, top/bottom growing, middle pref
    AC rowContraints = new AC()
       .grow().gap().size("pref").gap().grow();
    MigLayout layout = new MigLayout(layoutContraints, columnContraints,
            rowContraints);
    JPanel main = new JPanel(layout);
    main.setBackground(Color.WHITE);
    // add top spanning columns and growing
    main.add(northPanel, "spanx, grow");
    main.add(new JButton("FOO"));

    // well-behaved combo: max height == pref height
    JComboBox combo = new JComboBox() {

        @Override
        public Dimension getMaximumSize() {
            Dimension max = super.getMaximumSize();
            max.height = getPreferredSize().height;
            return max;
        }

    };
    // set a prototype to keep it from constantly adjusting
    combo.setPrototypeDisplayValue("somethingaslongasIwant");

    main.add(combo);
    // add top spanning columns and growing
    main.add(southPanel, "spanx, grow");