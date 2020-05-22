/**
 * Chop the input StringBuilder and give "..." at
 * maxOutput.
 * 
 * NOTE: no error checking
 */
private static String ourChop(StringBuilder sb, int maxOutput)
{
    if (sb.length() <= maxOutput) {
        return sb.toString();
    }

    // we chop everything past maxOutput - 3
    sb.setLength(maxOutput - 3);
    sb.append("...");

    return sb.toString();
}