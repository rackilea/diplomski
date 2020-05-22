CREATE CUSTOM INDEX counterparty_column_index ON counterparty (filter_column)
USING 'com.stratio.cassandra.lucene.Index'
WITH OPTIONS = {
    'schema' : '{
        fields : {
        controlling_team     : {type : "text", analyzer : "english"},
        relationship_manager : {type : "text", analyzer : "english"},
        review_date          : {type : "date", pattern : "dd-MM-yyyy"}
        }
    }'
};