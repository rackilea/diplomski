while (st.hasMoreTokens()) {
            //display csv values
            tokenNumber++;
            line = ("Title: " + st.nextToken()
                    + "\n" + "Make:" + st.nextToken()
                    + "\n" + "Model:" + st.nextToken()
                    + "\n" + "Year:" + st.nextToken()
                    + "\n" + "Price:" + st.nextToken()
                    + "\n" + "Notes:" + st.nextToken()
                    + "\n" + "Details:" + st.nextToken()
                    + "\n");

            textArea.setText(line);
        }