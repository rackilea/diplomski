Dispatcher.subscribe(Dispatcher.VERY_HIGH_PRIORITY, SessionOpenedAction.class)
     .filter(a -> isInPhotoMode())
     .subscribe(action -> {
           PhotoState newState = new PhotoState(state());
           newState.zslImageWriter = ImageWriter.newInstance(action.session.getInputSurface(), MAX_REPROCESS_IMAGES);
           setState(newState);
     });