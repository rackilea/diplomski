List<String> strs = Arrays.asList("(XYZTRR: KTTT 4.0.1; TVS A3003 WORD/LLLLL ; pj ;)", 
        "(XcdcdRR: dTff 5.4.1; TVS A3003 WORD/UJHKKKHH fpp)",
        "(LLLhf22; 776332 8.7.1; TVS A3003 WORD/UHHGFVV phhp) );");
Pattern pattern = Pattern.compile(";([^;]*?)WORD");
while (String s : strs) {
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()){
        System.out.println(matcher.group(1).trim()); 
    } 
}