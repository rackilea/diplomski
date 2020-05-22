import java.awt.Color;

/* Define the MAXIMUM saturation of RED and GREEN shades
 * Range (0-255)
 */
final int RED_MAX = 255;
final int GREEN_MAX = 255;

/* input val varies from -MAX to MAX */

/* output valColor varies from
 * -MAX = red
 *         ^
 *         |
 *         v
 *    0 = white
 *         ^
 *         |
 *         v
 *  MAX = green
 */

/* Normalised normVal varies from -255 to 255 */
normVal = (val*255)/MAX

if(val < 0) {
    /* Make it red-ish */
    valColor = new Color( RED_MAX,
                          255 + normVal, 
                          255 + normVal );
} else if (val > 0) {
    /* Make it green-ish */
    valColor = new Color( 255 - normVal), 
                          GREEN_MAX,
                          255 - normVal );
} else {
    /* Absolute White */
    valColor = new Color( 255, 255, 255 );
}