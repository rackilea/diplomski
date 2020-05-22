@Override
public boolean equals(Object another){
    Rule rule = (Rule) another;
    return left.equals(rule.left)
        && right.equals(rule.right)
        && lookupArtist.equals(rule.lookupArtist);
}