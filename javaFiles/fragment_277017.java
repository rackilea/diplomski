$dateParser.timezoneOffsetAdjust = function (date, timezone, undo) {
if (!date) {
    return null;
}
// Right now, only 'UTC' is supported.
if (timezone && timezone === 'UTC') {
    date = new Date(date.getTime());
    date.setMinutes(date.getMinutes() + (undo ? -1 : 1) * date.getTimezoneOffset());
}
return date;