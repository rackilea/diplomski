while ((aLine = br.readLine()) != null) {
            String[] sp = aLine.split(" ");
            if (sp[0].equals("0")) {
                break;
            }
            StringTokenizer st2 = new StringTokenizer(aLine, " ");
            Vector row = new Vector();

            while (st2.hasMoreTokens()) {

                String s = st2.nextToken();
                row.addElement(s);
            }

            data.addElement(row);
        }