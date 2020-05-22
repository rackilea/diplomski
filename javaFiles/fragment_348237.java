input {
  tcp {
    port => 3333
    type => "java"
  }
}

filter {
  if [type] == "java" {
    json {
      source => "message"
    }
  }
}

output {
  elasticsearch {
    hosts => "elasticsearch:9200"
  }
}