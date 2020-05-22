List<Integer> dices=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            dices.add(ThreadLocalRandom.current().nextInt(6)+1);
        }
        Collections.sort(dices);
        int stat1=dices.stream().skip(1).mapToInt(i->i.intValue()).sum();
        System.out.println("-------------------------");
        System.out.println(stat1);