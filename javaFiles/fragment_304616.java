output {
  stdout { codec => rubydebug }          <--- it must be here
  elasticsearch {
    hosts => ["localhost:9200"]
    index => "replacement_local100"
  }
}