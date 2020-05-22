/**
 * Play a sound from a sound ID.
 *
 * Play the sound specified by the soundID. This is the value 
 * returned by the load() function. Returns a non-zero streamID
 * if successful, zero if it fails. The streamID can be used to
 * further control playback. Note that calling play() may cause
 * another sound to stop playing if the maximum number of active
 * streams is exceeded. A loop value of -1 means loop forever,
 * a value of 0 means don't loop, other values indicate the
 * number of repeats, e.g. a value of 1 plays the audio twice.
 * The playback rate allows the application to vary the playback
 * rate (pitch) of the sound. A value of 1.0 means play back at
 * the original frequency. A value of 2.0 means play back twice
 * as fast, and a value of 0.5 means playback at half speed.
 *
 * @param soundID a soundID returned by the load() function
 * @param leftVolume left volume value (range = 0.0 to 1.0)
 * @param rightVolume right volume value (range = 0.0 to 1.0)
 * @param priority stream priority (0 = lowest priority)
 * @param loop loop mode (0 = no loop, -1 = loop forever)
 * @param rate playback rate (1.0 = normal playback, range 0.5 to 2.0)
 * @return non-zero streamID if successful, zero if failed
 */
public final int play(int soundID, float leftVolume, float rightVolume,
        int priority, int loop, float rate);

/**
 * Pause a playback stream.
 *
 * Pause the stream specified by the streamID. This is the
 * value returned by the play() function. If the stream is
 * playing, it will be paused. If the stream is not playing
 * (e.g. is stopped or was previously paused), calling this
 * function will have no effect.
 *
 * @param streamID a streamID returned by the play() function
 */
public final void pause(int streamID);