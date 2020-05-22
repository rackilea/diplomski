private ISolver solver;
...
if (comboBoxForMode.getSelectedItem()
                    .equals("one direct")) {
                OneDirectSolver solver = new OneDirectSolver();
                panelWithPicture = new OneDirectPanel();
                panelWithPicture.setSolver(solver);
                this.solver = solver;
            } else {
                BiDirectSolvable solver = new BiDirectSolver();
                panelWithPicture = new BiDirectPanel();
                panelWithPicture.setSolver(solver);
                this.solver = solver;
            }