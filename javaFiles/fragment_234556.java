switch (responseCode / 100) {
    case 1:
        /* informational response */
        break;
    case 2:
        /* success response */
        break;
    case 3:
        /* redirection response */
        break;
    case 4:
        /* client error response */
        break;
    case 5:
        /* server error response */
        break;
    default:
        /* bad response code */
        break;
}