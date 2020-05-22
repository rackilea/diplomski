switch (Boolean.toString(result.length <= 2)) {
    case "true":
        switch (result[0]) {
            case "UC":
            case "uc":
                fix = "UC";
                break;
            case "LC":
            case "lc":
                fix = "LC";
                break;
            default:
                fix = "error";
        }
        break;
    default:
        fix = "length";
}