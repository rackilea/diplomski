int count = 0;
if(request.getAtt1() !=null) {
    count++;
}
if(StringUtils.isNotEmpty(request.getAtt2())) {
    count++;
}
if(StringUtils.isNotEmpty(request.getAtt3())) {
    count++;
}

return count == 1;