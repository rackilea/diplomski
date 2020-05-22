{ 
  "aggs": { 
    "student_data": { 
      "date_histogram": { 
        "field":"@timestamp",
        "calendar_interval":"minute"
      },
      "aggs": { 
        "subject1_avg": { 
          "avg": { 
            "field":"subject1"
          }
        },
        "subject2_avg": { 
          "avg": { 
            "field":"subject2"
          }
        }
      }
    }
  }
}