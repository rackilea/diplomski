while(true) {

        Font newFont = font.deriveFont((float)fontSize + 1);
        int newWidth = StyleContext.getDefaultStyleContext().getFontMetrics(newFont).stringWidth(TEST_STIRNG);
        if(newWidth <= targetWidth) {
            fontSize++;
        } else {
            System.out.println("Rejected Font:" + newFont.getName() + " size:" + newFont.getSize() + " width: " + newWidth);        
            break;
        }
    }