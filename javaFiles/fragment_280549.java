switch(name) {
    case "meters":
        jsonreader.nextInt();
        break;
    case "ivs":
        jsonreader.nextInt();
        break;
    default:
        jsonreader.skipValue();
        break; // This one's technically optional because there's nothing to
               // fall through to, but including it makes your code cleaner
               // and more consistent
}