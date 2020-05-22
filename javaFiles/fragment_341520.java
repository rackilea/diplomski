filter {
   grok {
     match => [ "message" => "%{NOTSPACE:datetime} - %{LOGLEVEL:loglevel} - %{NOTSPACE:taskid} - %{NOTSPACE:logger} - %{WORD:label}( - %{INT:duration:int})?" ]
   }

   if [loglevel] =~ "FATAL" {
     drop { }
   }
}

output {
    elasticsearch {
          hosts => ["elasticsearch:9200"]
          index => "indexfatal-%{+YYYY.MM.dd}"
    }
}