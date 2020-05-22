PREFIX : <http://www.ontotext.com/connectors/lucene#>
PREFIX inst: <http://www.ontotext.com/connectors/lucene/instance#>
SELECT ?entity ?snippetField ?snippetText {
    ?search a inst:labelFR ;
            :query "label:*" ;
            :entities ?entity .
    ?entity :snippets _:s .
    _:s :snippetField ?snippetField ;
        :snippetText ?snippetText .
}