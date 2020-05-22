while ((getFontMetrics(f).stringWidth(longest) < allowedW)){
            //&& ((getFontMetrics(f).getHeight() * numData) < allowedH)) {
        System.out.println(longest);
        System.out.println("length " + getFontMetrics(f).stringWidth(longest));
        System.out.println("allowed width " + allowedW);
        System.out.println(fontSize);
        fontSize++;
        f = new Font("SansSerif", Font.BOLD, fontSize);//your f is not updated after increasing fontSize, if you put it as first statement.
    }
return new Font("SansSerif", Font.BOLD, fontSize - 1);