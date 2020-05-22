float delay = 0;
for (int i = 0; i < cells.length; ++i) {
    SequenceAction sa = Actions.sequence(Actions.delay(delay), 
                          Actions.fadeIn(1f));
    cell.addAction(sa);
    delay += 1f; //Increase the delay for the duration of each fadeIn
}