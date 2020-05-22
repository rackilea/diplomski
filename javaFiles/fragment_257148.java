String URL = "https://localhost:8080/sbs/01.00/sip/dreamworks/v/01.00/cui/print/$fwVer/{$fwVer}/$lang/en/$model/{$model}/$region/us/$imageBg/{$imageBg}/$imageH/{$imageH}/$imageSz/{$imageSz}/$imageW/{$imageW}/movie/Kung_Fu_Panda_two/categories/3D_Pix/item/{item}/_back/2?$uniqueID={$uniqueID}";
Pattern pattern = Pattern.compile("/\\{\\w+\\}/");
Matcher matcher = pattern.matcher(URL);
if (matcher.find()) {
    System.out.println(matcher.group(0)); //prints /{item}/
} else {
    System.out.println("Match not found");
}