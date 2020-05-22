enum ManaColor {

     RED, GREEN, BLUE, BLACK, WHITE;

}

class ManaCost {

    private int colorlessCost;
    private HashMap<ManaColor,Integer> colorCosts;

    public int getConvertedManaCost(){
        int convertedManaCost = 0;
        for(Integer colorCost : colorCosts.values()){
            convertedManaCost = convertedManaCost + colorCost;
        }
        convertedManaCost = convertedManaCost + colorlessCost;
        return convertedManaCost;
    }

    public Integer getColorCost(ManaColor color){
        return this.colorCosts.get(color);
    }

}

class Card {
    private ManaCost manaCost;
    ...
}