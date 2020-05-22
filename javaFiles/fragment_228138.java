String input; // yyyyMMdd_HHmm_ss_unitCode_(status)
SpecialClass output;

String regex = "(\\d{4})(\\d{2})(\\d{2})_(\\d{2})(\\d{2})_(\\d{2})_([^_]+)_\\((.+)\\)";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(input);

if (m.matches())
{
    output.year = m.group(1);
    output.month = m.group(2);
    // etc
}