pnlBottom.setPreferredSize(new Dimension(1, 20));

PainlessGridBag gbl = new PainlessGridBag(getContentPane(), false);
gbl.row().cell(pnlTop).fillXY();
gbl.row().cell(pnlBottom).fillX();
gbl.done();