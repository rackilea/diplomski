if (runs != null) {
    for (XWPFRun r : runs) {
        int i = 0;
        while (true) {
            try {
                String text = r.getText(i);

                if (text == null) {
                    break;
                }

                System.out.println(text);
                i++;
            } catch (IndexOutOfBoundsException ex) {
                break;
            }
        }    
    }
}