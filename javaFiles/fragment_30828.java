List<LcPawn> pawns = new ArrayList<>(256);
for (int i = 0; i < 256; i++) {
    LcPawn pawn = new LcPawn();
    pawn.setId(i);
    System.out.println(pawn.getId());
    pawns.add(pawn);
}