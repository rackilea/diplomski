Thing thing;
    for(int i=0;i<10;i++){
        thing = bag.bag.get(i);
        if(thing instanceof Creature){ 
            p1.addCreature((Creature)thing);
            bag.bag.remove(i);
        }
        else if(thing instanceof SpecialIncomeCounter){  
            p1.addSpecialIncomeCounter((SpecialIncomeCounter)thing);
            bag.bag.remove(i);
        }
    }