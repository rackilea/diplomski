#!/bin/bash

function run_cucumber_features {
  for file in $(find ./src/test  -name '*Steps.feature' -print0 | xargs -0);
  do
    gradle cucumberTest -Dcucumber.options="$file" DmutationTesting="false" -DmutationParameter="$parameter";
    echo "return code = $?"
  done
}

# to run the gradle script in the current directory
export PATH=$(pwd):${PATH}

run_cucumber_features