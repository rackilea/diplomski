String packName = null;
IconPackManager.IconPack packIcon = null;

IconPackManager ic = new IconPackManager();
HashMap<String, IconPackManager.IconPack> map = ic.getAvailableIconPacks(true);
Iterator it = map.entrySet().iterator();


        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            packName = (String)pair.getKey(); //Get icon pack name (app package)

            packIcon = (IconPackManager.IconPack)pair.getValue(); //Get icons

            if(packIcon.getDrawableIconForPackage("YourTargetPackageName", yourStandardIcon) != null) {

            //Your own method for set icon   
            setIcon(packIcon.getDrawableIconForPackage("YourTargetPackageName", yourStandardIcon));

            }else{
                //Your own method for set icon   
                setIcon(yourStandardIcon);
            }
        }