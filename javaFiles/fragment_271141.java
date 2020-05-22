public class StaticInfoBean {    
    private ArrayList<Region> regiones;
    private Region regionElegida;
    private Provincia provinciaElegida; // <-- you'll probably want this too...

    // ... getters and setters and your initialization code

    // and you need something to find the real region object that
    // used the reg_Cod value got from rich:select, for now you can try this:
    public void updateRegionElegida(AjaxBehaviorEvent e){
        // set the chosen region to regionElegida,
        // or the poor man's converter
        for (Region region : regiones){
            if(regionElegida.getReg_Cod() == region.getReg_cod()) {
                regionElegida = region;
            }
        }
    }
}