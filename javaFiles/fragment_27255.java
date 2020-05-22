public void Render(float fDelta, Canvas g) {
    final Cavas gFinal = g;
    final float fDeltaFinal = fDelta;
    ohHandler.render(new QTreeAction<Tile>() {
        @Override
        public void actToDo(Tile Param) {
            Param.render(fDeltaFinal , gFinal);
        }
    });
    this.pPlayer.render(fDelta, g);
}