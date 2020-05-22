/**
 * Modifies the standard behavior to allow results to be delivered to fragments.
 * This imposes a restriction that requestCode be <= 0xffff.
 */
@Override
public void startActivityForResult(Intent intent, int requestCode) {
    if (requestCode != -1 && (requestCode&0xffff0000) != 0) {
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }
    super.startActivityForResult(intent, requestCode);
}