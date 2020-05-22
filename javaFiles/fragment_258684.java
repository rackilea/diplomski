for (int i = 0; i < Modules.size(); i++) {
        ...
        if (inArrayModuleNummer == moduleNummer ) {

            System.out.print("inserted Module number excists \n");
            Modules.get(i).addWeek(new ModuleWeek(weekNummer, weekUren));
            return;
        }
    }
     // if you are here, the module number has no matching            
    System.out.print("inserted module number does not excist and the arraySize != 0");
    Module m = new Module(moduleNummer);
    m.addWeek(new ModuleWeek(weekNummer, weekUren));
    Modules.add(m);