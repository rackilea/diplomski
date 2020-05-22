{
  "viz": "query_value",
  "requests": [
    {
      "q": "avg:nginx.logs.request.count{*}.as_count()",
      "type": null,
      "style": {
        "palette": "dog_classic",
        "type": "solid",
        "width": "normal"
      },
      "aggregator": "last",
      "conditional_formats": [
        {
          "comparator": ">",
          "palette": "white_on_red",
          "value": null
        },
        {
          "comparator": ">=",
          "palette": "white_on_yellow",
          "value": null
        },
        {
          "comparator": "<",
          "palette": "white_on_green",
          "value": null
        }
      ]
    }
  ],
  "autoscale": true,
  "precision": "3"
}