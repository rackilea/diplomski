parse
  :  ( include_metric_units // match metrics
     | .                    // or any "dangling" single token
     )*                     // zero or more times
     EOF                    // end of the input
  ;

include_metric_units
  :  imperial_types+
  ;