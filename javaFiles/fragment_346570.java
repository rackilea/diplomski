String selector = "";
if(hasBaseCls()){
    selector += "." + getBaseCls();
}
if(hasCls()){
    selector += "." + getCls();
}
if (hasName()) {
    selector += "[name*='" + getName() + "']";
}
if(hasStyle()){
    selector += "[style*='" + getStyle() + "']";
}