/**
 * Sets the policy on whether cancelled tasks should be immediately
 * removed from the work queue at time of cancellation.  This value is
 * by default {@code false}.
 *
 * @param value if {@code true}, remove on cancellation, else don't
 * @see #getRemoveOnCancelPolicy
 * @since 1.7
 */
public void setRemoveOnCancelPolicy(boolean value) {
    removeOnCancel = value;
}