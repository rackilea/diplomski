Lifecycle.State state = getLifecycle().getCurrentState();
// The state could be either STARTED or RESUMED
boolean isStarted = state.isAtLeast(Lifecycle.State.STARTED)

// Paused means we aren't resumed
boolean isPaused = !state.isAtLeast(Lifecycle.State.RESUMED)