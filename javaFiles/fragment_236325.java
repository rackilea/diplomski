POST user_activity/user_activity/_search?search_type=count
{
  "query": {
    "match": {
      "activity": "TAG_SEARCH"
    }
  },
  "aggs": {
    "tags": {
      "terms": {
        "field": "tag"
      }
    }
  }
}