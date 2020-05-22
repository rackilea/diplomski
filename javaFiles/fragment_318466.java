action = new SequenceAction();
for(Unit u : units) {
  action.addAction(new MoveUnitAction( ... ));
  action.addAction(Actions.delay( gameSpeed ));
}
action.addAction(new SpawnUnitsAction( ... ));
action.addAction(Actions.delay( gameSpeed ));
action.addAction(new EndTurnAction( ... ));