Pattern PATTERN = Pattern.compile("(?>\"[^\"]+\"+)|(?>[^ ]+)+");
Matcher match = PATTERN.matcher(motRecherche);
match.reset();
int iM = 0;

while(match.find()){
    if(iM > 0){
        query.append("%20AND%20");
    }

    String utf_encoded = CommonUtils.escapeSolrQuery(match.group(0));
    query.append(":"+utf_encoded);
    iM++;
}