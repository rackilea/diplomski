for(Element tip: tips) {
        if(!"".equals(tip.text())) {
            if(!"&nbsp;".equals(tip.text())) {
                tipsArray.add(tip.text());
            }
        }