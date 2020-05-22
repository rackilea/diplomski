/**
 * Set whether this tab strip should draw a full-width underline in the
 * current tab indicator color.
 *
 * @param drawFull true to draw a full-width underline, false otherwise
 */
public void setDrawFullUnderline(boolean drawFull) {
    mDrawFullUnderline = drawFull;
    mDrawFullUnderlineSet = true;
    invalidate();
}