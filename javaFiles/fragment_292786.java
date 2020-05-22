for(int i = 0;i<competitors.length;i++){
        competitors[i] = new Competitor();
        System.out.println("Enter name, id and bounce height");
        competitors[i].SetName(sc.next());
        competitors[i].SetId(sc.next());
        competitors[i].SetHeight(sc.nextFloat());
    }