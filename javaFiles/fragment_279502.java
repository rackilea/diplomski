WakeLock(int flags, String tag)
{
    switch (flags & LOCK_MASK) {
    case PARTIAL_WAKE_LOCK:
    case SCREEN_DIM_WAKE_LOCK:
    case SCREEN_BRIGHT_WAKE_LOCK:
    case FULL_WAKE_LOCK:
    case PROXIMITY_SCREEN_OFF_WAKE_LOCK:
        break;
    default:
        throw new IllegalArgumentException();
    }

    mFlags = flags;
    mTag = tag;
    mToken = new Binder();
}