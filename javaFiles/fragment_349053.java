public static void main(String[] args) {

        //Initialize
        ArrayList<Exon> mainList = new ArrayList<>();
        Exon r1 = new Exon();
        r1.setStart(5);
        Exon r2 = new Exon();
        r2.setStart(10);
        Exon r3 = new Exon();
        r3.setStart(15);
        mainList.add(r1);
        mainList.add(r2);
        mainList.add(r3);

        //Print mainList
        System.out.println("Reg 1");
        for (Exon e : mainList) {
            System.out.println(e.getStart());
        }

        //Copy the mainList (I changed your foreach)
        List<Exon> copyList = mainList.stream().map(exon -> {

            //Create New Exon
            Exon copyExon = new Exon(exon);
            copyExon.setStart(2);
            return copyExon ;

        }).collect(Collectors.toList());

        //Print copyList
        System.out.println("Copy");
        for (Exon e : copyList) {
            System.out.println(e.getStart());
        }

        //Print mainList
        System.out.println("Reg 1 - untouched");
        for (Exon e : mainList) {
            System.out.println(e.getStart());
        }
    }