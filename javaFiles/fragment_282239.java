public class EscapeCodeUtil {

public static String createEscapeCode(int ... codes)
{
    StringBuilder sb = new StringBuilder();

    for(int code : codes)
        sb.append((char) code);

    return sb.toString();
}
}