switch (code_point) {

    case 'b':  newstr.append(boundary);
               break; /* switch */
    case 'B':  newstr.append(not_boundary);
               break; /* switch */

    case 'd':  newstr.append(digits_charclass);
               break; /* switch */
    case 'D':  newstr.append(not_digits_charclass);
               break; /* switch */

    case 'h':  newstr.append(horizontal_whitespace_charclass);
               break; /* switch */
    case 'H':  newstr.append(not_horizontal_whitespace_charclass);
               break; /* switch */

    case 'v':  newstr.append(vertical_whitespace_charclass);
               break; /* switch */
    case 'V':  newstr.append(not_vertical_whitespace_charclass);
               break; /* switch */

    case 'R':  newstr.append(linebreak);
               break; /* switch */

    case 's':  newstr.append(whitespace_charclass);
               break; /* switch */
    case 'S':  newstr.append(not_whitespace_charclass);
               break; /* switch */

    case 'w':  newstr.append(identifier_charclass);
               break; /* switch */
    case 'W':  newstr.append(not_identifier_charclass);
               break; /* switch */

    case 'X':  newstr.append(legacy_grapheme_cluster);
               break; /* switch */

    default:   newstr.append('\\');
               newstr.append(Character.toChars(code_point));
               break; /* switch */

}
saw_backslash = false;