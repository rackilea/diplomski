Matcher matcher = Pattern.compile("(VSHORT:(?<VSHORT>[^,]+))*,*(SHORT:(?<SHORT>[^,]+))*,*(MED:(?<MED>[^,]+))*,*(LONG:(?<LONG>[^,]+))*")
        .matcher("VSHORT:Ar,SHORT:Arsnl");

if (matcher.find()) {
    System.out.println(matcher.group("SHORT"));
}