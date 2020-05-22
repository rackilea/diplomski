SearchShardTarget shardTarget = new SearchShardTarget("1", "monitoring", 1);
ShardSearchFailure[] shardFailures = new ShardSearchFailure[0];
float score = 0.2345f;

BytesReference source = new BytesArray("{\"@timestamp\":\"2014-08-20T15:43:20.762Z\",\"category_name\""
        + ":\"cat1111\",\"alert_message\":\"the new cpu threshold has been reached 80%\",\"alert_type\":"
        + "\"Critical\",\"view_mode\":\"unread\"}");

InternalSearchHit hit = new InternalSearchHit(1, "5YmRf-6OTvelt29V5dphmw", new StringText("quota-management"),
        null);
hit.shardTarget(shardTarget);
hit.sourceRef(source);
hit.score(score);

InternalSearchHit[] hits = new InternalSearchHit[]{hit}; 
InternalSearchHits internalSearchHits = new InternalSearchHits(hits, 28, score);
InternalSearchResponse internalSearchResponse = new InternalSearchResponse(internalSearchHits, null, null,
      null, false);

SearchResponse searchResponse = new SearchResponse(internalSearchResponse, "scrollId", 1, 1, 1000, 
        shardFailures);