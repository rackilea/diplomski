"timeSeries": [
    {
      "metric": {
        "labels": {
          "instance_name": "instance-name"
        },
        "type": "compute.googleapis.com/instance/cpu/utilization"
      },
      "resource": {
        "type": "gce_instance",
        "labels": {
          "instance_id": "XXXXXXXXXXX",
          "zone": "XXXXXXXXX",
          "project_id": "your-project"
        }
      },
      "metricKind": "GAUGE",
      "valueType": "DOUBLE",
      "points": [
        {
          "interval": {
            "startTime": "2020-01-11T15:01:00Z",
            "endTime": "2020-01-11T15:01:00Z"
          },
          "value": {
            "doubleValue": 0.00097723160608135617
          }
        },
        {
          "interval": {
            "startTime": "2020-01-11T15:00:00Z",
            "endTime": "2020-01-11T15:00:00Z"
          },
          "value": {
            "doubleValue": 0.00092651031620789577
          }
....................................................