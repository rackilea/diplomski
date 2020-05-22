switch (dayOfYear > 20 ? (dayOfYear % 10) : dayOfYear) {
            case 1:  return dayOfYear + "st";
                     break;
            case 2:  return dayOfYear + "nd";
                     break;
            case 3:  return dayOfYear + "rd";
                     break;
            default:  return dayOfYear + "th";
                     break;   
}