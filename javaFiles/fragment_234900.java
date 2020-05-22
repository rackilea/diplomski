int bn = 9;
        if (bn % 3 == 0) {
            TableRow[] tr = new TableRow[bn / 3];
            for (int i = 1; i <=(bn / 3); i++) {
                tr[i] = new TableRow(this);
            }
        } else {
            TableRow[] tr = new TableRow[(bn / 3) + 1];
            for (int i = 1; i <=(bn / 3) + 1; i++) {
                tr[i] = new TableRow(this);
            }
        }