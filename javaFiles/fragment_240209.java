/**
 * Indicate whether the JSON output by this view should be prefixed with "{} &&". Default is false.
 * <p>Prefixing the JSON string in this manner is used to help prevent JSON Hijacking.
 * The prefix renders the string syntactically invalid as a script so that it cannot be hijacked.
 * This prefix does not affect the evaluation of JSON, but if JSON validation is performed on the
 * string, the prefix would need to be ignored.
 */
public void setPrefixJson(boolean prefixJson) {
    this.prefixJson = prefixJson;
}