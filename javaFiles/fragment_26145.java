@Override
public String toString() {
    StringBuilder sb = new StringBuilder(a).append(" = ");

    if (b > 1 || b < -1) {
        sb.append(b);
    } else if (b == -1) {
        sb.append('-');
    }

    if (b != 0) {
        sb.append('x ');

        if (c > 0) {
            sb.append('+');
        } else if (c < 0) {
            sb.append('-');
        }

        sb.append(' ');
    }

    sb.append(Math.abs(c));

    return sb.toString();
}