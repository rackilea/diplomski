/**
 * The sleep interval in milliseconds used in the main loop between shards polling cycles.
 * Defaults to {@code 1000} minimum {@code 250}.
 * @param idleBetweenPolls the interval to sleep between shards polling cycles.
 */
public void setIdleBetweenPolls(int idleBetweenPolls) {
    this.idleBetweenPolls = Math.max(250, idleBetweenPolls);
}