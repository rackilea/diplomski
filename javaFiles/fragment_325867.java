for (Integer a : intValues) {

            root= doc.createElement("root");

            for (int b = 1; b <= a; b++) {

                pattern.appendChild(root);
                example= doc.createElement("example");
                rule.appendChild(example);

            }
        }